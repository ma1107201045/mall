package com.lingyi.mall.web.admin.base.controller;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.biz.base.service.BaseService;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.security.admin.util.AuthenticatorUtil;
import com.lingyi.mall.security.core.aspetct.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:46
 * @description
 */
@Tag(name = "【系统基础服务】", description = "【系统基础服务】")
@RequestMapping("/admin/base/bases")
@RestController
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @Operation(summary = "更新当前用户信息", description = "更新当前用户信息")
    @PatchMapping("/user")
    @Log(title = "更新当前用户信息", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateUser(UserPartReqDTO userPartReqDTO) {
        var userId = AuthenticatorUtil.getUserId();
        baseService.updateUserByUserId(userId, userPartReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "获取当前用户菜单树", description = "获取当前用户菜单树")
    @GetMapping("/menu-trees")
    @Log(title = "获取当前用户菜单树", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<MenuRespDTO>> getMenuTrees() {
        var userName = AuthenticatorUtil.getUserName();
        var menus = baseService.readMenuTreesByUserName(userName);
        return ServerResponse.success(menus);
    }

    @Operation(summary = "获取当前用户菜单权限标识集", description = "获取当前用户菜单权限标识集")
    @GetMapping("/menu-permissions")
    @Log(title = "获取当前用户菜单权限标识集", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<String>> getMenuPermissions() {
        var userName = AuthenticatorUtil.getUserName();
        var permissions = baseService.readMenuPermissionsByUserName(userName);
        return ServerResponse.success(permissions);
    }


}
