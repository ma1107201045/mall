package com.lingyi.mall.web.app.sms.provider;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.feign.CaptchaFeign;
import com.lingyi.mall.api.sms.feign.SmsFeign;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 4:12
 * @Description:
 */
@Tag(name = "验证码", description = "验证码")
@Slf4j
@RequiredArgsConstructor
@RestController
public class CaptchaFeignProvider implements CaptchaFeign {
    private final CaptchaService captchaService;

    @Operation(summary = "发送验证码", description = "发送验证码")
    @Override
    public ServerResponse<Void> send(CaptchaSendReqDTO captchaSendReqDTO) {
        captchaService.send(captchaSendReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "校验验证码", description = "校验验证码")
    @Override
    public ServerResponse<Void> verify(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        captchaService.verify(captchaVerifyReqDTO);
        return ServerResponse.success();
    }
}
