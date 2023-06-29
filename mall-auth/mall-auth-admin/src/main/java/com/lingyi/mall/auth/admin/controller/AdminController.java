package com.lingyi.mall.auth.admin.controller;

import com.lingyi.mall.auth.admin.service.AdminService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 验证码接口
 */
@Slf4j
@Tag(name = "认证/授权接口", description = "认证/授权接口")
@Controller
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "获取验证码", description = "获取验证码")
    @GetMapping("/get-image-captcha")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ, ignoreParam = true)
    public void getCaptcha(HttpServletResponse response, HttpSession session) {
        adminService.writeImageCaptcha(response, session);
    }
}
