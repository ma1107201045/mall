package com.lingyi.mall.web.app.info.provider;

import com.lingyi.mall.api.info.dto.InfoCaptchaSendReqDTO;
import com.lingyi.mall.api.info.dto.InfoCaptchaVerifyReqDTO;
import com.lingyi.mall.api.info.dto.InfoReqDTO;
import com.lingyi.mall.api.info.feign.InfoFeign;
import com.lingyi.mall.biz.info.service.InfoService;
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
public class InfoFeignProvider implements InfoFeign {

    private final InfoService infoService;


    @Operation(summary = "发送", description = "发送")
    @Override
    public ServerResponse<Void> send(InfoReqDTO smsReqDTO) {
        infoService.send(smsReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "发送验证码", description = "发送验证码")
    @Override
    public ServerResponse<Void> sendCaptcha(InfoCaptchaSendReqDTO captchaReqDTO) {
        infoService.sendCaptcha(captchaReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "校验验证码", description = "校验验证码")
    @Override
    public ServerResponse<Void> verifyCaptcha(InfoCaptchaVerifyReqDTO captchaVerifyDTO) {
        infoService.verifyCaptcha(captchaVerifyDTO);
        return ServerResponse.success();
    }

}
