package com.lingyi.mall.auth.app.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import com.lingyi.mall.auth.app.model.dto.AuthAppEmailLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSmsLoginDTO;
import com.lingyi.mall.auth.app.model.vo.AuthAppLoginVO;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:25
 * @description
 */
@Tag(name = "认证", description = "登录、注销、发送验证码")
@RestController
@RequestMapping("/auth/app")
@RequiredArgsConstructor
public class AuthAppController {

    private final AuthAppService authAppService;

    @Operation(summary = "短信登录", description = "短信登录")
    @PostMapping("/sms-login")
    @SaIgnore
    public ServerResponse<AuthAppLoginVO> smsLogin(@Valid @RequestBody AuthAppSmsLoginDTO authAppSmsLoginDTO) {
        var authAppLoginVO = authAppService.smsLogin(authAppSmsLoginDTO);
        return ServerResponse.success(authAppLoginVO);
    }

    @Operation(summary = "邮箱登录", description = "邮箱登录")
    @PostMapping("/email-login")
    @SaIgnore
    public ServerResponse<AuthAppLoginVO> emailLogin(@Valid @RequestBody AuthAppEmailLoginDTO authAppEmailLoginDTO) {
        var authAppLoginVO = authAppService.emailLogin(authAppEmailLoginDTO);
        return ServerResponse.success(authAppLoginVO);
    }

    @Operation(summary = "注销", description = "注销")
    @PostMapping("/logout")
    @SaCheckLogin
    public ServerResponse<AuthAppLoginVO> logout() {
        authAppService.logout();
        return ServerResponse.success();
    }

    @Operation(summary = "发送验证码（短信或者邮箱）", description = "发送验证码（短信或者邮箱）")
    @PostMapping("/send-captcha")
    @SaIgnore
    public ServerResponse<Void> sendCaptcha(@Valid @RequestBody AuthAppSendDTO authAppSendDTO) {
        authAppService.sendCaptcha(authAppSendDTO);
        return ServerResponse.success();
    }


}
