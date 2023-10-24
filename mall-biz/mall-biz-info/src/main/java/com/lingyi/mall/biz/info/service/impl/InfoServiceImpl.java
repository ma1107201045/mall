package com.lingyi.mall.biz.info.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.info.dto.InfoCaptchaSendReqDTO;
import com.lingyi.mall.api.info.dto.InfoCaptchaVerifyReqDTO;
import com.lingyi.mall.api.info.dto.InfoReqDTO;
import com.lingyi.mall.biz.info.converter.CaptchaConverter;
import com.lingyi.mall.biz.info.enums.SmsFailEnum;
import com.lingyi.mall.biz.info.model.entity.LogDO;
import com.lingyi.mall.biz.info.service.InfoService;
import com.lingyi.mall.biz.info.service.LogService;
import com.lingyi.mall.biz.info.util.InfoRedisKeyUtil;
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
public class InfoServiceImpl implements InfoService {

    private final LogService logService;

    private final RedisUtil redisUtil;

    private final InfoRedisKeyUtil infoRedisKeyUtil;

    @Override
    @RedisLock(keySuffix = "#infoReqDTO.serviceType + ':' + #infoReqDTO.businessType + ':' +#infoReqDTO.type + ':' + #infoReqDTO.number")
    public void send(InfoReqDTO infoReqDTO) {
        //校验数据
        verifyData(infoReqDTO);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                setUpperLimitAndIntervalTime((RedisOperations<String, Object>) redisOperations, infoReqDTO);
                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(infoReqDTO);
    }

    @Override
    @RedisLock(keySuffix = "#infoCaptchaSendReqDTO.serviceType + ':' + #infoCaptchaSendReqDTO.businessType + ':' +#infoCaptchaSendReqDTO.type + ':' + #infoCaptchaSendReqDTO.number")
    public void sendCaptcha(InfoCaptchaSendReqDTO infoCaptchaSendReqDTO) {
        //校验数据
        verifyData(infoCaptchaSendReqDTO);
        //操作redis
        redisUtil.execPipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(@NotNull RedisOperations<K, V> redisOperations) throws DataAccessException {
                RedisOperations<String, Object> operations = (RedisOperations<String, Object>) redisOperations;
                //设置上线跟失效时间
                setUpperLimitAndIntervalTime(operations, infoCaptchaSendReqDTO);
                //设置验证码
                setCaptcha(operations, infoCaptchaSendReqDTO);

                return ObjectUtil.getNull();
            }
        });
        //TODO 发送mq消息
        //保存日志
        createLog(infoCaptchaSendReqDTO);
    }

    @Override
    public void verifyCaptcha(InfoCaptchaVerifyReqDTO infoCaptchaVerifyReqDTO) {
        var smsCaptchaKey = infoRedisKeyUtil.getCaptchaKey(infoCaptchaVerifyReqDTO);
        var sourceCaptcha = redisUtil.get(smsCaptchaKey, String.class);
        var targetCaptcha = infoCaptchaVerifyReqDTO.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, SmsFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(smsCaptchaKey);
    }

    private void verifyData(InfoReqDTO infoReqDTO) {
        //校验发送上限
        var upperLimitKey = infoRedisKeyUtil.getUpperLimitKey(infoReqDTO);
        var upperLimitValue = redisUtil.get(upperLimitKey, Integer.class);
        var flag = Objects.nonNull(upperLimitValue) && infoReqDTO.getUpperLimit().equals(upperLimitValue);
        AssertUtil.isFalse(flag, SmsFailEnum.SMS_UPPER_LIMIT_ERROR);

        //校验发送间隔
        var intervalTimeKey = infoRedisKeyUtil.getIntervalTimeKey(infoReqDTO);
        var intervalTimeValue = redisUtil.get(intervalTimeKey, Integer.class);
        AssertUtil.isNull(intervalTimeValue, SmsFailEnum.SMS_INTERVAL_ERROR);
    }

    private void setUpperLimitAndIntervalTime(RedisOperations<String, Object> operations, InfoReqDTO infoReqDTO) {
        var upperLimitKey = infoRedisKeyUtil.getUpperLimitKey(infoReqDTO);
        //设置发送间隔标记,并且第二天凌晨失效
        operations.opsForValue().increment(upperLimitKey);
        operations.expire(upperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);

        //设置发送标记
        var intervalTimeKey = infoRedisKeyUtil.getIntervalTimeKey(infoReqDTO);
        operations.opsForValue().set(intervalTimeKey, RandomUtil.randomInt(), infoReqDTO.getIntervalTime(), TimeUnit.MINUTES);
    }


    private void setCaptcha(RedisOperations<String, Object> operations, InfoCaptchaSendReqDTO captchaSendReqDTO) {
        var captchaKey = infoRedisKeyUtil.getCaptchaKey(captchaSendReqDTO);
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

    private void createLog(InfoReqDTO infoReqDTO) {
        //转换成验证码日志信息
        var captchaLogDTO = CaptchaConverter.INSTANCE.to(infoReqDTO);
        //保存短信日志
        logService.create(captchaLogDTO, LogDO.class);
    }
}
