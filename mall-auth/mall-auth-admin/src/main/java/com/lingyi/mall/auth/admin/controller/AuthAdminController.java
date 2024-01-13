package com.lingyi.mall.auth.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.auth.admin.model.dto.LoginDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.LoginVO;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
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
    @Log(title = "登录", operationType = OperationTypeEnum.READ)
    @SaIgnore
    @PostMapping("/login")
    @ResponseBody
    public LoginVO login(@RequestBody LoginDTO loginDTO) {
        LoginVO loginVO = authAdminService.login(loginDTO);
        StpUtil.login(loginVO.getUserId(), WhetherEnum.Y.getCode().equals(loginDTO.getIsRememberMe()));
        StpUtil.getSession().set("user", loginVO);
        return loginVO;
    }

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @SaIgnore
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    public ImageCaptchaVO getBase64ImageCaptcha() {
        return authAdminService.readImageCaptcha();
    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @Log(title = "获取图形验证码-二进制流", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @SaIgnore
    @GetMapping("/get-bin-image-captcha")
    public void writeBinImageCaptcha() {
        authAdminService.writeImageCaptcha();
    }

    @Operation(summary = "注销", description = "注销")
    @Log(title = "注销", operationType = OperationTypeEnum.READ)
    @SaCheckLogin
    @DeleteMapping("/logout")
    @ResponseBody
    public void logout() {
        StpUtil.logout();
    }
}
