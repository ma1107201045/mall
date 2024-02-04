package com.lingyi.mall.web.app.info.provider;

import cn.dev33.satoken.annotation.SaIgnore;
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
@Tag(name = "provider-信息服务", description = "provider-信息服务")
@RestController
@SaIgnore
@RequiredArgsConstructor
public class InfoFeignProvider implements InfoFeign {

    private final InfoService infoService;


    @Override
    public ServerResponse<Void> send(InfoRequest infoRequest) {
        infoService.send(infoRequest);
        return ServerResponse.success();
    }


    @Override
    public ServerResponse<Void> sendCaptcha(InfoCaptchaSendRequest infoCaptchaSendRequest) {
        infoService.sendCaptcha(infoCaptchaSendRequest);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse<Void> verifyCaptcha(InfoCaptchaVerifyRequest infoCaptchaVerifyRequest) {
        infoService.verifyCaptcha(infoCaptchaVerifyRequest);
        return ServerResponse.success();
    }

}
