package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.biz.sms.converter.CaptchaConverter;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.exception.SmsException;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.biz.sms.util.SmsRedisKeyUtil;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.redis.aspect.RedisLock;
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
public class CaptchaServiceImpl implements CaptchaService {

    private final CaptchaLogService captchaLogService;

    private final RedisUtil redisUtil;

    private final SmsRedisKeyUtil smsRedisKeyUtil;


    @Override
    @RedisLock(keySuffix = "#captchaSendReqDTO.serviceType + ':' + #captchaSendReqDTO.businessType + ':' + #captchaSendReqDTO.phoneNumber")
    public void send(CaptchaSendReqDTO captchaSendReqDTO) {
        //校验验证码当天发送上限
        var captchaUpperLimitKey = smsRedisKeyUtil.getCaptchaUpperLimitKey(captchaSendReqDTO);
        var captchaUpperLimitValue = redisUtil.get(captchaUpperLimitKey, Integer.class);
        if (Objects.nonNull(captchaUpperLimitValue) && !(captchaUpperLimitValue < captchaSendReqDTO.getUpperLimit())) {
            throw new SmsException(SmsFailEnum.CAPTCHA_UPPER_LIMIT_ERROR);
        }

        //校验验证码发送间隔时间
        var captchaIntervalDateKey = smsRedisKeyUtil.getCaptchaIntervalDateKey(captchaSendReqDTO);
        var captchaIntervalDateValue = redisUtil.get(captchaIntervalDateKey, Integer.class);
        AssertUtil.isNull(captchaIntervalDateValue, SmsFailEnum.CAPTCHA_INTERVAL_DATE_ERROR);

        //设置验证码失效时间
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaSendReqDTO);
        redisUtil.set(captchaKey, captchaSendReqDTO.getCaptcha(), captchaSendReqDTO.getExpiryDate(), TimeUnit.MINUTES);

        //TODO 发送mq消息

        //设置验证码发送间隔时间随机值
        redisUtil.set(captchaIntervalDateKey, RandomUtil.randomInt(), captchaSendReqDTO.getIntervalDate(), TimeUnit.MINUTES);

        //验证码发送次数累加
        redisUtil.incr(captchaUpperLimitKey);
        if (Objects.isNull(captchaUpperLimitValue)) {
            //第二天凌晨失效
            redisUtil.expire(captchaUpperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);
        }
        //转换成验证码日志信息
        var captchaLogDO = CaptchaConverter.INSTANCE.to(captchaSendReqDTO);
        //保存验证码日志
        captchaLogService.create(captchaLogDO);
    }


    @Override
    public void verify(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaVerifyReqDTO);
        var sourceCaptcha = redisUtil.get(captchaKey, String.class);
        var targetCaptcha = captchaVerifyReqDTO.getCaptcha();
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
