package com.lingyi.mall.web.admin.base.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.biz.base.service.BaseService;
import com.lingyi.mall.security.core.util.AuthenticatorUtil;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:46
 * @description
 */
@Tag(name = "基础接口", description = "基础接口")
@RequestMapping("/bases")
@RestController
@SaCheckLogin
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @Operation(summary = "更新当前用户信息", description = "更新当前用户信息")
    @PatchMapping("/user")
    public ServerResponse<Void> updateUser(@Valid @RequestBody UserPartRequest userPartRequest) {
        var userId = AuthenticatorUtil.getCurrentUserId();
        baseService.updateUserByUserId(userId, userPartRequest);
        return ServerResponse.success();
    }

    @Operation(summary = "获取当前用户菜单树", description = "获取当前用户菜单树")
    @GetMapping("/menu-trees")
    public ServerResponse<List<MenuResponse>> getMenuTrees() {
        var userId = AuthenticatorUtil.getCurrentUserId();
        var menus = baseService.readMenuTreesByUserId(userId);
        return ServerResponse.success(menus);
    }

    @Operation(summary = "获取当前用户菜单权限标识集", description = "获取当前用户菜单权限标识集")
    @GetMapping("/menu-permissions")
    public ServerResponse<List<String>> getMenuPermissions() {
        var userId = AuthenticatorUtil.getCurrentUserId();
        var permissions = baseService.readMenuPermissionsByUserId(userId);
        return ServerResponse.success(permissions);
    }


}
