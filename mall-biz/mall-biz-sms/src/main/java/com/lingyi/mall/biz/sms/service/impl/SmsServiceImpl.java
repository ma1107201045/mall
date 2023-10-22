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
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
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
        //校验
        verifyData(smsReqDTO);
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                execRedis((RedisOperations<String, Object>) redisOperations, smsReqDTO);
                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(smsReqDTO);
    }

    @Override
    @RedisLock(keySuffix = "#captchaSendReqDTO.serviceType + ':' + #captchaSendReqDTO.businessType + ':' +#captchaSendReqDTO.type + ':' + #captchaSendReqDTO.phoneNumber")
    public void sendCaptcha(CaptchaSendReqDTO captchaSendReqDTO) {
        //校验
        verifyData(captchaSendReqDTO);
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                RedisOperations<String, Object> operations = (RedisOperations<String, Object>) redisOperations;
                //操作redis
                execRedis(operations, captchaSendReqDTO);
                //设置验证码
                var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaSendReqDTO);
                operations.opsForValue().set(captchaKey, captchaSendReqDTO.getCaptcha(), captchaSendReqDTO.getCaptchaExpiryDate(), TimeUnit.MINUTES);
                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(captchaSendReqDTO);
    }


    @Override
    public void verifyCaptcha(CaptchaVerifyReqDTO captchaVerifyDTO) {
        var captchaKey = smsRedisKeyUtil.getCaptchaKey(captchaVerifyDTO);
        var sourceCaptcha = redisUtil.get(captchaKey, String.class);
        var targetCaptcha = captchaVerifyDTO.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, SmsFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(captchaKey);
    }

    private void verifyData(SmsReqDTO smsReqDTO) {
        //校验发送上限
        var smsUpperLimitKey = smsRedisKeyUtil.getSmsUpperLimitKey(smsReqDTO);
        var smsUpperLimitValue = redisUtil.get(smsUpperLimitKey, Integer.class);
        var flag = Objects.nonNull(smsUpperLimitValue) && smsReqDTO.getUpperLimit().equals(smsUpperLimitValue);
        AssertUtil.isFalse(flag, SmsFailEnum.SMS_UPPER_LIMIT_ERROR);

        //校验发送间隔
        var smsIntervalKey = smsRedisKeyUtil.getSmsIntervalKey(smsReqDTO);
        var smsIntervalValue = redisUtil.get(smsIntervalKey, Integer.class);
        AssertUtil.isNull(smsIntervalValue, SmsFailEnum.SMS_INTERVAL_ERROR);
    }

    private void execRedis(RedisOperations<String, Object> operations, SmsReqDTO smsReqDTO) {
        var smsUpperLimitKey = smsRedisKeyUtil.getSmsUpperLimitKey(smsReqDTO);
        var smsIntervalKey = smsRedisKeyUtil.getSmsIntervalKey(smsReqDTO);
        //设置发送间隔标记,并且第二天凌晨失效
        operations.opsForValue().increment(smsUpperLimitKey);
        operations.expire(smsUpperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);

        //设置发送标记
        operations.opsForValue().set(smsIntervalKey, RandomUtil.randomInt(), smsReqDTO.getIntervalTime(), TimeUnit.MINUTES);
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

    /**
     * 保存日志
     *
     * @param smsReqDTO .。
     */
    private void createLog(SmsReqDTO smsReqDTO) {
        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(smsReqDTO);
        //保存短信日志
        logService.create(captchaLogDTO, LogDO.class);
    }
}
