package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.biz.sms.util.CaptchaRedisKeyUtil;
import com.lingyi.mall.common.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 4:04
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private final LogService sendLogService;

    private final RedisUtil redisUtil;

    private final CaptchaRedisKeyUtil smsRedisKeyUtil;



}
