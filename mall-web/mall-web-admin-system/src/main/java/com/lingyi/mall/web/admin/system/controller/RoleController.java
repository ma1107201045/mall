package com.lingyi.mall.web.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lingyi.mall.biz.system.model.dto.RoleDTO;
import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.log.enums.OperationTypeEnum;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/16 21:18
 * @Description:
 */
@Tag(name = "系统角色", description = "系统角色")
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:save")
    public ServerResponse<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:delete")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        roleService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:update")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        roleService.updateByDTO(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:get")
    public ServerResponse<RoleVO> getById(@PathVariable Long id) {
        var roleVO = roleService.readById(id);
        return ServerResponse.success(roleVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:getList")
    public ServerResponse<List<RoleVO>> getListByPageAndParam(@Valid RoleQuery roleQuery) {
        var total = roleService.totalByParam(roleQuery);
        var roles = roleService.readListByParam(roleQuery);
        return ServerResponse.success(roles, total);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @GetMapping("/menu-tree")
    @SaCheckLogin
    @SaCheckPermission("admin:system:roles:menus:getTree")
    public ServerResponse<List<MenuVO>> getMenuTree() {
        var menuTree = roleService.readMenuTree();
        return ServerResponse.success(menuTree);
    }
}
