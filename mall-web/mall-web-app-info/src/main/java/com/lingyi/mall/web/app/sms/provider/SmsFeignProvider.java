package com.lingyi.mall.web.app.sms.provider;

import com.lingyi.mall.api.sms.dto.SmsCaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.SmsCaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.feign.SmsFeign;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:18
 * @description
 */
@Tag(name = "验证码", description = "验证码")
@RequiredArgsConstructor
@RestController
public class SmsFeignProvider implements SmsFeign {

    private final SmsService smsService;


    @Operation(summary = "发送", description = "发送")
    @Override
    public ServerResponse<Void> send(SmsReqDTO smsReqDTO) {
        smsService.send(smsReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "发送验证码", description = "发送验证码")
    @Override
    public ServerResponse<Void> sendCaptcha(SmsCaptchaSendReqDTO captchaReqDTO) {
        smsService.sendCaptcha(captchaReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "校验验证码", description = "校验验证码")
    @Override
    public ServerResponse<Void> verifyCaptcha(SmsCaptchaVerifyReqDTO captchaVerifyDTO) {
        smsService.verifyCaptcha(captchaVerifyDTO);
        return ServerResponse.success();
    }

}
