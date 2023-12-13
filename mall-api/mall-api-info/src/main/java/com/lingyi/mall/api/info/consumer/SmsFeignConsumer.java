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

    public void send(InfoRequest infoRequest) {
        log.info("入参:smsReqDTO:{}", infoRequest);
        var response = infoFeign.send(infoRequest);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void sendCaptcha(InfoCaptchaSendRequest infoCaptchaSendRequest) {
        log.info("入参:infoCaptchaSendReqDTO:{}", infoCaptchaSendRequest);
        var response = infoFeign.sendCaptcha(infoCaptchaSendRequest);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public void verifyCaptcha(InfoCaptchaVerifyRequest infoCaptchaVerifyRequest) {
        log.info("入参:infoCaptchaVerifyReqDTO:{}", infoCaptchaVerifyRequest);
        var response = infoFeign.verifyCaptcha(infoCaptchaVerifyRequest);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
