package com.lingyi.mall.api.info.feign;

import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.api.info.fallbackfactory.InfoFeignFallbackFactory;
import com.lingyi.mall.common.web.util.ServerResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
    String URL_PREFIX = "/provider/infos";


    /**
     * 发送验证码
     *
     * @param infoRequest ..
     * @return ServerResponse
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> send(@RequestBody InfoRequest infoRequest);

    /**
     * @param infoCaptchaSendRequest ..
     * @return ServerResponse
     */
    @PostMapping(URL_PREFIX + "/send-captcha")
    ServerResponse<Void> sendCaptcha(@RequestBody InfoCaptchaSendRequest infoCaptchaSendRequest);

    /**
     * 保存验证码
     *
     * @param infoCaptchaVerifyRequest ..
     * @return ServerResponse
     */
    @GetMapping(URL_PREFIX + "/verify-captcha")
    ServerResponse<Void> verifyCaptcha(@Valid InfoCaptchaVerifyRequest infoCaptchaVerifyRequest);


}
