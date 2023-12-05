package com.lingyi.mall.auth.app.controller;

import com.lingyi.mall.auth.app.model.dto.AuthAppEmailLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSmsLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.model.vo.AuthAppLoginVO;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:25
 * @description
 */
@Tag(name = "认证", description = "认证")
@Validated
@RestController
@RequestMapping("/auth/app")
@RequiredArgsConstructor
public class AuthAppController {

    private final AuthAppService authAppService;

    @Operation(summary = "发送验证码（短信或者邮箱）", description = "发送验证码（短信或者邮箱）")
    @PostMapping("/send-captcha")
    public ServerResponse<Void> sendCaptcha(AuthAppSendDTO authAppSendDTO) {
        authAppService.sendCaptcha(authAppSendDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "手机号登录", description = "手机号登录")
    @PostMapping("/sms-login")
    public ServerResponse<AuthAppLoginVO> smsLogin(@Valid @RequestBody AuthAppSmsLoginDTO authAppSmsLoginDTO) {
        var authAppLoginVO = authAppService.smsLogin(authAppSmsLoginDTO);
        return ServerResponse.success(authAppLoginVO);
    }

    @Operation(summary = "邮箱登录", description = "邮箱登录")
    @PostMapping("/email-login")
    public ServerResponse<AuthAppLoginVO> emailLogin(@Valid @RequestBody AuthAppEmailLoginDTO authAppEmailLoginDTO) {
        var authAppLoginVO = authAppService.emailLogin(authAppEmailLoginDTO);
        return ServerResponse.success(authAppLoginVO);
    }

    @Operation(summary = "注销", description = "注销")
    @PostMapping("/logout")
    public ServerResponse<AuthAppLoginVO> logout() {
        authAppService.logout();
        return ServerResponse.success();
    }

}
