package com.lingyi.mall.web.app.info.provider;

import com.lingyi.mall.api.info.feign.InfoFeign;
import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoCaptchaVerifyRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.biz.info.service.InfoService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
public class InfoFeignProvider implements InfoFeign {

    private final InfoService infoService;


    @Operation(summary = "发送", description = "发送")
    @Override
    public ServerResponse<Void> send(InfoRequest infoRequest) {
        infoService.send(infoRequest);
        return ServerResponse.success();
    }

    @Operation(summary = "发送验证码", description = "发送验证码")
    @Override
    public ServerResponse<Void> sendCaptcha(InfoCaptchaSendRequest captchaReqDTO) {
        infoService.sendCaptcha(captchaReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "校验验证码", description = "校验验证码")
    @Override
    public ServerResponse<Void> verifyCaptcha(InfoCaptchaVerifyRequest infoCaptchaVerifyRequest) {
        infoService.verifyCaptcha(infoCaptchaVerifyRequest);
        return ServerResponse.success();
    }

}
