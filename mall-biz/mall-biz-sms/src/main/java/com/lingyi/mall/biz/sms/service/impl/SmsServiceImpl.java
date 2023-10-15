package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.biz.sms.converter.CaptchaConverter;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.model.entity.LogDO;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.biz.sms.util.SmsRedisKeyUtil;
import com.lingyi.mall.common.core.annotation.RedisLock;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final LogService logService;

    private final RedisUtil redisUtil;

    private final SmsRedisKeyUtil smsRedisKeyUtil;


    @Override
    @RedisLock(keySuffix = "#smsReqDTO.serviceType + ':' + #smsReqDTO.businessType + ':' + #smsReqDTO.phoneNumber")
    public void send(SmsReqDTO smsReqDTO) {
        //校验发送上限
        var smsUpperLimitKey = smsRedisKeyUtil.getSmsUpperLimitKey(smsReqDTO);
        var smsUpperLimitValue = redisUtil.get(smsUpperLimitKey, Integer.class);
        var flag = Objects.nonNull(smsUpperLimitValue) && smsReqDTO.getUpperLimit().equals(smsUpperLimitValue);
        AssertUtil.isFalse(flag, SmsFailEnum.SMS_UPPER_LIMIT_ERROR);
        //设置发送间隔标记
        redisUtil.incr(smsUpperLimitKey);
        if (Objects.isNull(smsUpperLimitValue)) {
            //第二天凌晨失效
            redisUtil.expire(smsUpperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);
        }


        //校验发送间隔
        var smsIntervalKey = smsRedisKeyUtil.getSmsIntervalKey(smsReqDTO);
        var smsIntervalValue = redisUtil.get(smsIntervalKey, Integer.class);
        AssertUtil.isNull(smsIntervalValue, SmsFailEnum.SMS_INTERVAL_ERROR);
        //设置发送标记
        redisUtil.set(smsIntervalKey, RandomUtil.randomInt(), smsReqDTO.getInterval(), TimeUnit.MINUTES);


        //TODO 发送mq消息

        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(smsReqDTO);
        //保存短信日志
        logService.create(captchaLogDTO, LogDO.class);
    }

    @Override
    public void sendCaptcha(CaptchaSendReqDTO captchaSendReqDTO) {
        //发送短信
        send(captchaSendReqDTO);
        //设置验证码
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaSendReqDTO);
        redisUtil.set(captchaKey, captchaSendReqDTO.getCaptcha(), captchaSendReqDTO.getCaptchaExpiryDate(), TimeUnit.MINUTES);
    }


    @Override
    public void verifyCaptcha(CaptchaVerifyReqDTO captchaVerifyDTO) {
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaVerifyDTO);
        var sourceCaptcha = redisUtil.get(captchaKey, String.class);
        var targetCaptcha = captchaVerifyDTO.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, SmsFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(captchaKey);
    }


    /**
     * 当前时间戳与第二天凌晨时间戳差值
     *
     * @return 时间戳
     */
    private long getSubTimestamp() {
        var startDateTime = LocalDateTime.now();
        var endDateTime = LocalDateTime.of(startDateTime.plusDays(1).toLocalDate(), LocalTime.MIN);
        return endDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - startDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

}
