package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
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
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.MBeanAttributeInfo;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
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
        redisUtil.set(intervalDateKey, IdUtil.fastSimpleUUID(), captchaSendReqDTO.getIntervalDate(), TimeUnit.MINUTES);
        //验证码发送次数累加
        redisUtil.incr(upperLimitKey);
        if (Objects.isNull(nowUpperLimitValue)) {
            //第二天凌晨失效
            LocalDateTime time01 = LocalDateTime.now();
            LocalDateTime time02 = LocalDateTime.of(time01.plusDays(1).toLocalDate(), LocalTime.MIN);
            long subTimestamp = time02.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - time01.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
            redisUtil.expire(upperLimitKey, subTimestamp, TimeUnit.MILLISECONDS);
        }
        //转换成验证码日志信息
        CaptchaLogDO captchaLogDO = ConverterUtil.to(captchaSendReqDTO, CaptchaLogDO.class);
        //保存验证码日志
        captchaLogService.create(captchaLogDO);
    }


    @Override
    public Boolean verify(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        String targetCaptcha = captchaVerifyReqDTO.getCaptcha();
        String sourceCaptcha = redisUtil.get(redisKeyUtil.getCaptchaExpiryDateKey(captchaVerifyReqDTO), String.class);
        return StrUtil.isNotBlank(targetCaptcha) && targetCaptcha.equals(sourceCaptcha);
    }

}
