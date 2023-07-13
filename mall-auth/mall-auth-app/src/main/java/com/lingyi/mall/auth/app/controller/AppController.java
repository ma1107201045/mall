package com.lingyi.mall.auth.app.controller;

import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:25
 * @description
 */
@Tag(name = "app认证", description = "登录、验证码相关接口")
@Validated
@RestController
@RequestMapping("/auth/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @Operation(summary = "手机号登录", description = "手机号登录")
    @PostMapping("/login")
    public ServerResponse<AppLoginVO> login(@Valid @RequestBody AppLoginDTO appLoginDTO) {
        AppLoginVO apploginVo = appService.login(appLoginDTO);
        return ServerResponse.success(apploginVo);
    }

    @Operation(summary = "发送短信验证码", description = "发送短信验证码")
    @GetMapping("/send-sms-captcha")
    public ServerResponse<Void> sendSmsCaptcha(@NotBlank(message = "手机号不能为空") String phoneNumber) {
        appService.sendSmsCaptcha(phoneNumber);
        return ServerResponse.success();
    }

}
