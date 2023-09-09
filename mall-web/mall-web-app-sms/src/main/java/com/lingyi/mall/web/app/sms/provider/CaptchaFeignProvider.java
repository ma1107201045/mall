package com.lingyi.mall.web.app.sms.provider;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.feign.CaptchaFeign;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:18
 * @description
 */
@Tag(name = "短信验证码", description = "短信验证码")
@Slf4j
@RequiredArgsConstructor
@RestController
public class CaptchaFeignProvider implements CaptchaFeign {

    private final CaptchaService captchaService;

    @Operation(summary = "发送", description = "发送")
    @Override
    public ServerResponse<Void> send(CaptchaSendReqDTO captchaSendReqDTO) {
        captchaService.send(captchaSendReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "校验", description = "校验")
    @Override
    public ServerResponse<Void> verify(CaptchaVerifyReqDTO captchaVerifyReqDTO) {
        captchaService.verify(captchaVerifyReqDTO);
        return ServerResponse.success();
    }
}
