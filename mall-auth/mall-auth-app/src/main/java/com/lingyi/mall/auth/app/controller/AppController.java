package com.lingyi.mall.auth.app.controller;

import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppRegisterDTO;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import com.lingyi.mall.common.util.ServerResponse;
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
@Tag(name = "app认证", description = "登录、注册、验证码相关接口")
@Validated
@RestController
@RequestMapping("/auth/app")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

    @Operation(summary = "登录", description = "登录")
    @PostMapping("/login")
    public ServerResponse<AppLoginVO> login(@Valid @RequestBody AppLoginDTO appLoginDTO) {
        AppLoginVO apploginVo = appService.login(appLoginDTO);
        return ServerResponse.success(apploginVo);
    }

    @Operation(summary = "注册", description = "注册")
    @PostMapping("/register")
    public ServerResponse<Void> register(@Valid @RequestBody AppRegisterDTO appRegisterDTO) {
        appService.register(appRegisterDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "发送验证码", description = "发送验证码")
    @GetMapping("/send-verification-code")
    public ServerResponse<Void> sendVerificationCode(@NotBlank(message = "手机号不能为空") String phoneNumber) {
        appService.sendVerificationCode(phoneNumber);
        return ServerResponse.success();
    }

}
