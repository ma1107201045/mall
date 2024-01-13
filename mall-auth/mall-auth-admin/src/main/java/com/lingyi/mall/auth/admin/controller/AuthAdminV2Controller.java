package com.lingyi.mall.auth.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.auth.admin.model.dto.LoginDTO;
import com.lingyi.mall.auth.admin.model.vo.ImageCaptchaVO;
import com.lingyi.mall.auth.admin.model.vo.LoginVO;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.core.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class AuthAdminV2Controller {

    private final AuthAdminService authAdminService;

    @Operation(summary = "登录", description = "登录")
    @Parameters(
            {
                    @Parameter(name = "userName", description = "用户名", in = ParameterIn.QUERY),
                    @Parameter(name = "password", description = "密码", in = ParameterIn.QUERY),
                    @Parameter(name = "isRememberMe", description = "是否记住我 1 是 0 否", in = ParameterIn.QUERY),
                    @Parameter(name = "uuid", description = "uuid,用户验证图形", in = ParameterIn.QUERY),
                    @Parameter(name = "imageCaptcha", description = "图像验证码", in = ParameterIn.QUERY),
            })
    @Log(title = "登录", operationType = OperationTypeEnum.READ)
    @GetMapping("/login")
    @ResponseBody
    @SaIgnore
    public LoginVO login(LoginDTO loginDTO) {
        LoginVO loginVO = authAdminService.login(loginDTO);
        StpUtil.login(loginVO.getUserId());
        return loginVO;
    }

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    @SaIgnore
    public ImageCaptchaVO getBase64ImageCaptcha() {
        return authAdminService.readImageCaptcha();
    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @Log(title = "获取图形验证码-二进制流", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-bin-image-captcha")
    @SaIgnore
    public void writeBinImageCaptcha() {
        authAdminService.writeImageCaptcha();
    }

    @Operation(summary = "注销", description = "注销")
    @Log(title = "注销", operationType = OperationTypeEnum.READ)
    @DeleteMapping("/logout")
    @SaCheckLogin
    @ResponseBody
    public void logout() {
        StpUtil.logout();
    }
}
