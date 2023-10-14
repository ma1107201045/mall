package com.lingyi.mall.api.sms.feign;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.fallbackfactory.CapchaFeignFallbackFactory;
import com.lingyi.mall.api.sms.fallbackfactory.SmsFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 4:08
 * @Description:
 */
@FeignClient(value = "mall-web-app-sms", fallbackFactory = CapchaFeignFallbackFactory.class)
public interface CaptchaFeign {
    String URL_PREFIX = "/app/captchas";


    /**
     * 发送验证码
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
