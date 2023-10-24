package com.lingyi.mall.api.sms.feign;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.fallbackfactory.SmsFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:14
 * @description
 */
@FeignClient(value = "mall-web-app-sms", fallbackFactory = SmsFeignFallbackFactory.class)
public interface SmsFeign {
    String URL_PREFIX = "/app/sms";


    /**
     * 发送验证码
     *
     * @param smsReqDTO ..
     * @return ServerResponse
     */
    @PostMapping
    ServerResponse<Void> send(@RequestBody SmsReqDTO smsReqDTO);

    /**
     * @param captchaReqDTO
     * @return
     */
    @PostMapping("/send-captcha")
    @GetMapping
    ServerResponse<Void> sendCaptcha(@RequestBody CaptchaSendReqDTO captchaReqDTO);

    /**
     * 保存验证码
     *
     * @param captchaVerifyDTO ..
     * @return ServerResponse
     */
    @GetMapping("/verify-captcha")
    ServerResponse<Void> verifyCaptcha(@RequestBody CaptchaVerifyReqDTO captchaVerifyDTO);


}
