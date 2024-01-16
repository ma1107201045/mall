package com.lingyi.mall.auth.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.auth.admin.model.dto.AuthenticatorDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthenticatorVO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 20:42
 * @Description:
 */
@Tag(name = "认证", description = "登录、注销、获取验证码")
@Controller
@RequiredArgsConstructor
public class AuthAdminController {

    private final AuthAdminService authAdminService;

    @Operation(summary = "登录", description = "登录")
    @PostMapping("/login")
    @ResponseBody
    @SaIgnore
    public ServerResponse<AuthenticatorVO> login(@RequestBody AuthenticatorDTO authenticatorDTO) {
        var authenticatorVO = authAdminService.login(authenticatorDTO);
        return ServerResponse.success(authenticatorVO);
    }


    @Operation(summary = "注销", description = "注销")
    @DeleteMapping("/logout")
    @ResponseBody
    @SaCheckLogin
    public ServerResponse<Void> logout() {
        authAdminService.logout();
        return ServerResponse.success();
    }

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    @SaIgnore
    public ServerResponse<ImageCaptchaVO> getBase64ImageCaptcha() {
        ImageCaptchaVO imageCaptchaVO = authAdminService.readImageCaptcha();
        return ServerResponse.success(imageCaptchaVO);
    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @GetMapping("/get-bin-image-captcha")
    @SaIgnore
    public void writeBinImageCaptcha() {
        authAdminService.writeImageCaptcha();
    }
}
