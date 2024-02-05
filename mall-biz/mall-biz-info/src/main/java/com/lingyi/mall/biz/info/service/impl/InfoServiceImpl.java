package com.lingyi.mall.biz.info.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.biz.info.converter.CaptchaConverter;
import com.lingyi.mall.biz.info.enums.InfoFailEnum;
import com.lingyi.mall.biz.info.model.entity.InfoLogDO;
import com.lingyi.mall.biz.info.service.InfoService;
import com.lingyi.mall.biz.info.service.InfoLogService;
import com.lingyi.mall.biz.info.util.InfoRedisKeyUtil;
import com.lingyi.mall.common.redis.aspect.annotation.RedisLock;
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
public class InfoServiceImpl implements InfoService {

    private final InfoLogService infoLogService;

    private final RedisUtil redisUtil;

    private final InfoRedisKeyUtil infoRedisKeyUtil;

    @Override
    @RedisLock(keySuffix = "#infoReqDTO.serviceType + ':' + #infoReqDTO.businessType + ':' +#infoReqDTO.type + ':' + #infoReqDTO.number")
    public void send(InfoRequest request) {
        //校验数据
        verifyData(request);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @SuppressWarnings("unchecked")
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                setUpperLimitAndIntervalTime((RedisOperations<String, Object>) redisOperations, request);
                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(request);
    }

    @Override
    @RedisLock(keySuffix = "#infoCaptchaSendReqDTO.serviceType + ':' + #infoCaptchaSendReqDTO.businessType + ':' +#infoCaptchaSendReqDTO.type + ':' + #infoCaptchaSendReqDTO.number")
    public void sendCaptcha(InfoCaptchaSendRequest request) {
        //校验数据
        verifyData(request);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @SuppressWarnings("unchecked")
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                RedisOperations<String, Object> operations = (RedisOperations<String, Object>) redisOperations;
                //设置上线跟失效时间
                setUpperLimitAndIntervalTime(operations, request);
                //设置验证码
                setCaptcha(operations, request);

                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(request);
    }

    @Override
    public void verifyCaptcha(InfoCaptchaVerifyRequest request) {
        var smsCaptchaKey = infoRedisKeyUtil.getCaptchaKey(request);
        var sourceCaptcha = redisUtil.get(smsCaptchaKey, String.class);
        var targetCaptcha = request.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, InfoFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(smsCaptchaKey);
    }

    private void verifyData(InfoRequest request) {
        //校验发送上限
        var upperLimitKey = infoRedisKeyUtil.getUpperLimitKey(request);
        var upperLimitValue = redisUtil.get(upperLimitKey, Integer.class);
        var flag = Objects.nonNull(upperLimitValue) && request.getUpperLimit().equals(upperLimitValue);
        AssertUtil.isFalse(flag, InfoFailEnum.SMS_UPPER_LIMIT_ERROR);

        //校验发送间隔
        var intervalTimeKey = infoRedisKeyUtil.getIntervalTimeKey(request);
        var intervalTimeValue = redisUtil.get(intervalTimeKey, Integer.class);
        AssertUtil.isNull(intervalTimeValue, InfoFailEnum.SMS_INTERVAL_ERROR);
    }

    private void setUpperLimitAndIntervalTime(RedisOperations<String, Object> operations, InfoRequest request) {
        var upperLimitKey = infoRedisKeyUtil.getUpperLimitKey(request);
        //设置发送间隔标记,并且第二天凌晨失效
        operations.opsForValue().increment(upperLimitKey);
        operations.expire(upperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);

        //设置发送标记
        var intervalTimeKey = infoRedisKeyUtil.getIntervalTimeKey(request);
        operations.opsForValue().set(intervalTimeKey, RandomUtil.randomInt(), request.getIntervalTime(), TimeUnit.MINUTES);
    }


    private void setCaptcha(RedisOperations<String, Object> operations, InfoCaptchaSendRequest request) {
        var captchaKey = infoRedisKeyUtil.getCaptchaKey(request);
        operations.opsForValue().set(captchaKey, request.getCaptcha(), request.getCaptchaExpiryDate(), TimeUnit.MINUTES);
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

    private void createLog(InfoRequest request) {
        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(request);
        //保存短信日志
        infoLogService.create(captchaLogDTO, InfoLogDO.class);
    }
}
