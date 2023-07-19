package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.exception.SmsException;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.biz.sms.util.RedisKeyUtil;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.cache.aspect.RedisLock;
import com.lingyi.mall.common.cache.util.RedisUtil;
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

    private final RedisKeyUtil redisKeyUtil;


    @Override
    @RedisLock(keySuffix = "#captchaSendReqDTO.serviceType + ':' + #captchaSendReqDTO.businessType + ':' + #captchaSendReqDTO.phoneNumber")
    public void send(CaptchaSendReqDTO captchaSendReqDTO) {
        //校验验证码当天发送上限
        String upperLimitKey = redisKeyUtil.getCaptchaUpperLimitKey(captchaSendReqDTO);
        Integer nowUpperLimitValue = redisUtil.get(upperLimitKey, Integer.class);
        Integer upperLimitValue = captchaSendReqDTO.getUpperLimit();
        if (Objects.nonNull(nowUpperLimitValue) && (nowUpperLimitValue.equals(upperLimitValue) || nowUpperLimitValue > upperLimitValue)) {
            throw new SmsException(SmsFailEnum.CAPTCHA_UPPER_LIMIT_ERROR);
        }
        //校验验证码发送间隔时间
        String intervalDateKey = redisKeyUtil.getCaptchaIntervalDateKey(captchaSendReqDTO);
        String intervalDateValue = redisUtil.get(intervalDateKey, String.class);
        AssertUtil.isNull(intervalDateValue, SmsFailEnum.CAPTCHA_INTERVAL_DATE_ERROR);

        //设置验证码失效时间
        String expiryDateKey = redisKeyUtil.getCaptchaExpiryDateKey(captchaSendReqDTO);
        redisUtil.set(expiryDateKey, captchaSendReqDTO.getCaptcha(), captchaSendReqDTO.getExpiryDate(), TimeUnit.MINUTES);

        //TODO 发送mq消息

        //设置验证码发送间隔时间随机值
        redisUtil.set(intervalDateKey, RandomUtil.randomInt(), captchaSendReqDTO.getIntervalDate(), TimeUnit.MINUTES);
        //验证码发送次数累加
        redisUtil.incr(upperLimitKey);
        if (Objects.isNull(nowUpperLimitValue)) {
            //第二天凌晨失效
            redisUtil.expire(upperLimitKey, getSubTimestamp(), TimeUnit.MILLISECONDS);
        }
        //转换成验证码日志信息
        CaptchaLogDO captchaLogDO = ConverterUtil.to(captchaSendReqDTO, CaptchaLogDO.class);
        //保存验证码日志
        captchaLogService.create(captchaLogDO);
    }


    @Override
    public void verify(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        String captchaExpiryDateKey = redisKeyUtil.getCaptchaExpiryDateKey(captchaVerifyReqDTO);
        String sourceCaptcha = redisUtil.get(captchaExpiryDateKey, String.class);
        String targetCaptcha = captchaVerifyReqDTO.getCaptcha();
        AssertUtil.isEquals(targetCaptcha, sourceCaptcha, SmsFailEnum.CAPTCHA_EXPIRY_DATE_ERROR);
        redisUtil.delete(captchaExpiryDateKey);
    }

    /**
     * 当前时间戳与第二天凌晨时间戳差值
     *
     * @return 时间戳
     */
    private long getSubTimestamp() {
        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.of(startDateTime.plusDays(1).toLocalDate(), LocalTime.MIN);
        return endDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - startDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
}
