package com.lingyi.mall.auth.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.auth.admin.model.dto.AuthenticatorDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthenticatorVO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.core.enums.WhetherEnum;
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
    public AuthenticatorVO login(@RequestBody AuthenticatorDTO authenticatorDTO) {
        AuthenticatorVO authenticatorVO = authAdminService.login(authenticatorDTO);
        StpUtil.login(authenticatorVO.getUserId(), WhetherEnum.Y.getCode().
                equals(authenticatorDTO.getIsRememberMe()));
        StpUtil.getSession().set(StpUtil.TYPE, authenticatorVO);
        return authenticatorVO;
    }

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    @SaIgnore
    public ImageCaptchaVO getBase64ImageCaptcha() {
        return authAdminService.readImageCaptcha();
    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @GetMapping("/get-bin-image-captcha")
    @SaIgnore
    public void writeBinImageCaptcha() {
        authAdminService.writeImageCaptcha();
    }

    @Operation(summary = "注销", description = "注销")
    @DeleteMapping("/logout")
    @ResponseBody
    @SaCheckLogin
    public void logout() {
        StpUtil.logout();
    }
}
