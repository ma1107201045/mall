package com.lingyi.mall.auth.admin.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 验证码接口
 */
@Slf4j
@Tag(name = "验证码", description = "验证码")
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthAdminController {

    private final AuthAdminService authAdminService;

    @Operation(summary = "获取图形验证码-base64", description = "获取图形验证码-base64")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-base64-image-captcha")
    @ResponseBody
    public ServerResponse<String> getBase64ImageCaptcha(HttpSession session) {
        var imageCaptcha = authAdminService.readImageCaptcha(session);
        return ServerResponse.success(imageCaptcha);

    }

    @Operation(summary = "获取图形验证码-二进制流", description = "获取图形验证码-二进制流")
    @Log(title = "获取图形验证码-二进制流", operationType = OperationTypeEnum.READ, ignoreParam = true)
    @GetMapping("/get-bin-image-captcha")
    public void writeBinImageCaptcha(HttpSession session, HttpServletResponse response) {
        authAdminService.writeImageCaptcha(session, response);
    }
}
