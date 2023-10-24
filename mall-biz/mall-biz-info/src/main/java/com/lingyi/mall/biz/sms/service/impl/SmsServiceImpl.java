package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.SmsCaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.SmsCaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.biz.sms.converter.CaptchaConverter;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.model.entity.LogDO;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.biz.sms.util.SmsRedisKeyUtil;
import com.lingyi.mall.common.core.annotation.RedisLock;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
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
    @RedisLock(keySuffix = "#smsReqDTO.serviceType + ':' + #smsReqDTO.businessType + ':' +#smsReqDTO.type + ':' + #smsReqDTO.phoneNumber")
    public void send(SmsReqDTO smsReqDTO) {
        //校验数据
        verifyData(smsReqDTO);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                setUpperLimitAndIntervalTime((RedisOperations<String, Object>) redisOperations, smsReqDTO);
                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(smsReqDTO);
    }

    @Override
    @RedisLock(keySuffix = "#smsCaptchaSendReqDTO.serviceType + ':' + #smsCaptchaSendReqDTO.businessType + ':' +#smsCaptchaSendReqDTO.type + ':' + #smsCaptchaSendReqDTO.phoneNumber")
    public void sendCaptcha(SmsCaptchaSendReqDTO smsCaptchaSendReqDTO) {
        //校验数据
        verifyData(smsCaptchaSendReqDTO);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                RedisOperations<String, Object> operations = (RedisOperations<String, Object>) redisOperations;
                //设置上线跟失效时间
                setUpperLimitAndIntervalTime(operations, smsCaptchaSendReqDTO);
                //设置验证码
                setCaptcha(operations, smsCaptchaSendReqDTO);

                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(smsCaptchaSendReqDTO);
    }

    @Override
    public void verifyCaptcha(SmsCaptchaVerifyReqDTO captchaVerifyDTO) {
        var smsCaptchaKey = smsRedisKeyUtil.getSmsCaptchaKey(captchaVerifyDTO);
        var sourceCaptcha = redisUtil.get(smsCaptchaKey, String.class);
        var targetCaptcha = captchaVerifyDTO.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, SmsFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(smsCaptchaKey);
    }

    private void verifyData(SmsReqDTO smsReqDTO) {
        //校验发送上限
        var upperLimitKey = smsRedisKeyUtil.getUpperLimitKey(smsReqDTO);
        var upperLimitValue = redisUtil.get(upperLimitKey, Integer.class);
        var flag = Objects.nonNull(upperLimitValue) && smsReqDTO.getUpperLimit().equals(upperLimitValue);
        AssertUtil.isFalse(flag, SmsFailEnum.SMS_UPPER_LIMIT_ERROR);

        //校验发送间隔
        var intervalTimeKey = smsRedisKeyUtil.getIntervalTimeKey(smsReqDTO);
        var intervalTimeValue = redisUtil.get(intervalTimeKey, Integer.class);
        AssertUtil.isNull(intervalTimeValue, SmsFailEnum.SMS_INTERVAL_ERROR);
    }

    private void setUpperLimitAndIntervalTime(RedisOperations<String, Object> operations, SmsReqDTO smsReqDTO) {
        var upperLimitKey = smsRedisKeyUtil.getUpperLimitKey(smsReqDTO);
        //设置发送间隔标记,并且第二天凌晨失效
        operations.opsForValue().increment(upperLimitKey);
        operations.expire(upperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);

        //设置发送标记
        var intervalTimeKey = smsRedisKeyUtil.getIntervalTimeKey(smsReqDTO);
        operations.opsForValue().set(intervalTimeKey, RandomUtil.randomInt(), smsReqDTO.getIntervalTime(), TimeUnit.MINUTES);
    }


    private void setCaptcha(RedisOperations<String, Object> operations, SmsCaptchaSendReqDTO captchaSendReqDTO) {
        var captchaKey = smsRedisKeyUtil.getSmsCaptchaKey(captchaSendReqDTO);
        operations.opsForValue().set(captchaKey, captchaSendReqDTO.getCaptcha(), captchaSendReqDTO.getCaptchaExpiryDate(), TimeUnit.MINUTES);
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

    private void createLog(SmsReqDTO smsReqDTO) {
        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(smsReqDTO);
        //保存短信日志
        logService.create(captchaLogDTO, LogDO.class);
    }
}
