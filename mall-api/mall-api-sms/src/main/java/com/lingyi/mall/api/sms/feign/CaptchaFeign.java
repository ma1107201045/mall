package com.lingyi.mall.api.sms.feign;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.fallbackfactory.CaptchaFeignFallbackFactory;
import com.lingyi.mall.common.base.util.ServerResponse;
import lombok.Getter;
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
@FeignClient(value = "mall-web-app-sms", fallbackFactory = CaptchaFeignFallbackFactory.class)
public interface CaptchaFeign {
    String URL_PREFIX = "/app/sms/captchas";

    /**
     * 保存验证码
     *
     * @param captchaSendReqDTO ..
     * @return ServerResponse
     */
    @PostMapping(URL_PREFIX + "/send")
    ServerResponse<Void> send(@RequestBody CaptchaSendReqDTO captchaSendReqDTO);


    /**
     * 保存验证码
     *
     * @param captchaVerifyReqDTO ..
     * @return ServerResponse
     */
    @PostMapping(URL_PREFIX + "/verify")
    ServerResponse<Void> verify(@RequestBody CaptchaVerifyReqDTO captchaVerifyReqDTO);

}
