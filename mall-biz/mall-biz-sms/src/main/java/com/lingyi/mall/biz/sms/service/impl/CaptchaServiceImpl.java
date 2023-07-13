package com.lingyi.mall.biz.sms.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.sms.dto.CaptchaReqDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.biz.sms.util.RedisKeyUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public void send(CaptchaReqDTO captchaReqDTO) {
        //生成验证码
        String captcha = RandomUtil.randomNumbers(captchaReqDTO.getLength());
        //设置有效期
        redisUtil.set(redisKeyUtil.getCaptchaKey(captchaReqDTO), captcha, captchaReqDTO.getExpiryDate(), TimeUnit.MINUTES);
        //TODO 发送mq消息
        //转换成验证码日志信息
        CaptchaLogDO captchaLogDO = ConverterUtil.to(captchaReqDTO, CaptchaLogDO.class);
        //保存验证码日志
        captchaLogService.create(captchaLogDO);
    }

}
