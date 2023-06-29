package com.lingyi.mall.auth.admin.controller;

import com.lingyi.mall.auth.admin.service.AdminService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 验证码接口
 */
@Slf4j
@Tag(name = "认证/授权接口", description = "认证/授权接口")
@RestController
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "获取图形验证码", description = "获取图形验证码")
    @GetMapping("/get-image-captcha")
    @Log(title = "获取验证码", operationType = OperationTypeEnum.READ)
    public ServerResponse<String> getImageCaptcha() {
        String imageCaptcha = adminService.readImageCaptcha();
        return ServerResponse.success(imageCaptcha);

    }
}
