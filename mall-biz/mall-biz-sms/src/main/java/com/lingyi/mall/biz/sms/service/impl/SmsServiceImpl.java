package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.SmsAbstractReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.biz.sms.converter.CaptchaConverter;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.exception.SmsException;
import com.lingyi.mall.biz.sms.model.entity.LogDO;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.biz.sms.util.CaptchaRedisKeyUtil;
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

    private final LogService sendLogService;

    private final RedisUtil redisUtil;

    private final CaptchaRedisKeyUtil smsRedisKeyUtil;


    @Override
    @RedisLock(keySuffix = "#captchaSendReqDTO.serviceType + ':' + #captchaSendReqDTO.businessType + ':' + #captchaSendReqDTO.phoneNumber")
    public void send(SmsReqDTO smsReqDTO) {
        //校验验证码当天发送上限
        var captchaUpperLimitKey = smsRedisKeyUtil.getCaptchaUpperLimitKey(smsReqDTO);
        var captchaUpperLimitValue = redisUtil.get(captchaUpperLimitKey, Integer.class);
        if (Objects.nonNull(captchaUpperLimitValue) && !(captchaUpperLimitValue < smsReqDTO.getUpperLimit())) {
            throw new SmsException(SmsFailEnum.CAPTCHA_UPPER_LIMIT_ERROR);
        }

        //校验验证码发送间隔时间
        var captchaIntervalDateKey = smsRedisKeyUtil.getCaptchaIntervalDateKey(smsReqDTO);
        var captchaIntervalDateValue = redisUtil.get(captchaIntervalDateKey, Integer.class);
        AssertUtil.isNull(captchaIntervalDateValue, SmsFailEnum.CAPTCHA_INTERVAL_DATE_ERROR);

        //设置验证码失效时间
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(smsReqDTO);
        redisUtil.set(captchaKey, smsReqDTO.getCaptcha(), smsReqDTO.getExpiryDate(), TimeUnit.MINUTES);

        //TODO 发送mq消息

        //设置验证码发送间隔时间随机值
        redisUtil.set(captchaIntervalDateKey, RandomUtil.randomInt(), smsReqDTO.getIntervalDate(), TimeUnit.MINUTES);

        //验证码发送次数累加
        redisUtil.incr(captchaUpperLimitKey);
        if (Objects.isNull(captchaUpperLimitValue)) {
            //第二天凌晨失效
            redisUtil.expire(captchaUpperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);
        }
        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(smsReqDTO);
        //保存短信日志
        sendLogService.create(captchaLogDTO, LogDO.class);
    }


    @Override
    public void verifyCaptcha(SmsAbstractReqDTO smsCaptchaReqDTO) {
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(smsCaptchaReqDTO);
        var sourceCaptcha = redisUtil.get(captchaKey, String.class);
        var targetCaptcha = smsCaptchaReqDTO.getCaptcha();
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
