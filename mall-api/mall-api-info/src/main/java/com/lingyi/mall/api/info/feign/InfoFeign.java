package com.lingyi.mall.api.info.feign;

import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.api.info.fallbackfactory.InfoFeignFallbackFactory;
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
@FeignClient(value = "mall-web-app-info", fallbackFactory = InfoFeignFallbackFactory.class)
public interface InfoFeign {
    String URL_PREFIX = "/app/sms";


    /**
     * 发送验证码
     *
     * @param smsReqDTO ..
     * @return ServerResponse
     */
    @PostMapping
    ServerResponse<Void> send(@RequestBody InfoRequest smsReqDTO);

    /**
     * @param captchaReqDTO
     * @return
     */
    @PostMapping("/send-captcha")
    @GetMapping
    ServerResponse<Void> sendCaptcha(@RequestBody InfoCaptchaSendRequest captchaReqDTO);

    /**
     * 保存验证码
     *
     * @param captchaVerifyDTO ..
     * @return ServerResponse
     */
    @GetMapping("/verify-captcha")
    ServerResponse<Void> verifyCaptcha(@RequestBody InfoCaptchaVerifyRequest captchaVerifyDTO);


}
