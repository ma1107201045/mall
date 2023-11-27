package com.lingyi.mall.api.info.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.api.info.feign.InfoFeign;
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
public class SmsFeignConsumer {

    private final InfoFeign infoFeign;

    public void send(InfoRequest smsReqDTO) {
        log.info("入参:smsReqDTO:{}", smsReqDTO);
        var response = infoFeign.send(smsReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void sendCaptcha(InfoCaptchaSendRequest infoCaptchaSendReqDTO) {
        log.info("入参:infoCaptchaSendReqDTO:{}", infoCaptchaSendReqDTO);
        var response = infoFeign.sendCaptcha(infoCaptchaSendReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void verifyCaptcha(InfoCaptchaVerifyRequest infoCaptchaVerifyReqDTO) {
        log.info("入参:infoCaptchaVerifyReqDTO:{}", infoCaptchaVerifyReqDTO);
        var response = infoFeign.verifyCaptcha(infoCaptchaVerifyReqDTO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
