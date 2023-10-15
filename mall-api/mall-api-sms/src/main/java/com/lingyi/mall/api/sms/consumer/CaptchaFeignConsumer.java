package com.lingyi.mall.api.sms.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
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

    public void sendCaptcha(CaptchaSendReqDTO captchaSendReqDTO) {
        log.info("入参:captchaSendReqDTO:{}", captchaSendReqDTO);
        var response = captchaFeign.sendCaptcha(captchaSendReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void verifyCaptcha(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        log.info("入参:captchaVerifyReqDTO:{}", captchaVerifyReqDTO);
        var response = captchaFeign.verifyCaptcha(captchaVerifyReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
