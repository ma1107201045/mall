package com.lingyi.mall.api.sms.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.sms.dto.SmsAbstractReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.feign.SmsFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:24
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CaptchaFeignConsumer {

    private final SmsFeign captchaFeign;

    public void send(SmsAbstractReqDTO captchaSendReqDTO) {
        log.info("入参:captchaReqDTO:{}", captchaSendReqDTO);
        var response = captchaFeign.send(captchaSendReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void verify(SmsReqDTO captchaVerifyReqDTO) {
        log.info("入参:captchaVerifyReqDTO:{}", captchaVerifyReqDTO);
        var response = captchaFeign.verify(captchaVerifyReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
