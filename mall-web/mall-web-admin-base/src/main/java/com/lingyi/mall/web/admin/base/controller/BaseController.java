package com.lingyi.mall.web.admin.base.controller;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.biz.base.service.BaseService;
import com.lingyi.mall.common.base.util.AuthenticatorUtil;
import com.lingyi.mall.common.util.ServerResponse;
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

    @Operation(summary = "获取菜单", description = "获取菜单")
    @GetMapping("/menu")
    public ServerResponse<List<MenuResDTO>> getMenu() {
        String userName = AuthenticatorUtil.getUserName();
        List<MenuResDTO> menus = baseService.findMenuTreeByUserName(userName);
        return ServerResponse.success(menus);
    }

    @Operation(summary = "更新用户信息", description = "更新用户信息")
    @PatchMapping("/user")
    public ServerResponse<Void> updateUser(UserPartReqDTO userPartDTO) {
        Long userId = AuthenticatorUtil.getUserId();
        baseService.editUserByUserId(userId, userPartDTO);
        return ServerResponse.success();
    }
}
