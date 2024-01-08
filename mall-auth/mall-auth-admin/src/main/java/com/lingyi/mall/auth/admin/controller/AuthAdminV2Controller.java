package com.lingyi.mall.auth.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.auth.admin.model.dto.AuthAdminDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthAdminVO;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.core.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class AuthAdminV2Controller {

    private final AuthAdminService authAdminService;

    @Operation(summary = "登录", description = "登录")
    @Log(title = "登录", operationType = OperationTypeEnum.READ)
    @PostMapping("/login")
    @ResponseBody
    @SaIgnore
    public AuthAdminVO login(@RequestBody AuthAdminDTO authAdminDTO) {
        AuthAdminVO authAdminVO = authAdminService.login(authAdminDTO);
        StpUtil.login(authAdminVO.getUserId());
        return authAdminVO;
    }

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    @SaIgnore
    public ServerResponse<String> getBase64ImageCaptcha(HttpSession session) {
        var imageCaptcha = authAdminService.readImageCaptcha(session);
        return ServerResponse.success(imageCaptcha);

    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @Log(title = "获取图形验证码-二进制流", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-bin-image-captcha")
    @SaIgnore
    public void writeBinImageCaptcha(HttpSession session, HttpServletResponse response) {
        authAdminService.writeImageCaptcha(session, response);
    }

    @Operation(summary = "注销", description = "注销")
    @Log(title = "注销", operationType = OperationTypeEnum.READ)
    @PostMapping("/logout")
    @SaCheckLogin
    @ResponseBody
    public void logout() {
        StpUtil.logout();
    }
}
