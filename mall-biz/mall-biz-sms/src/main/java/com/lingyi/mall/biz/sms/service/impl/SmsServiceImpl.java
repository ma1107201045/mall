package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.biz.sms.service.SendLogService;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.biz.sms.util.CaptchaRedisKeyUtil;
import com.lingyi.mall.common.core.annotation.RedisLock;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final SendLogService sendLogService;

    private final RedisUtil redisUtil;

    private final CaptchaRedisKeyUtil smsRedisKeyUtil;


    @Override
    @RedisLock(keySuffix = "#captchaSendReqDTO.serviceType + ':' + #captchaSendReqDTO.businessType + ':' + #captchaSendReqDTO.phoneNumber")
    public void send(SmsReqDTO smsReqDTO) {

    }


}
