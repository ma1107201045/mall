package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.common.core.annotation.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/16 21:18
 * @Description:
 */
@Tag(name = "【系统管理服务-角色】", description = "【系统管理服务-角色】")
@RequestMapping("/admin/system/roles")
@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:save')")
    @Log(title = "保存角色", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:delete')")
    @Log(title = "删除角色", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        roleService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:update')")
    @Log(title = "更新角色", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        roleService.updateById(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:get')")
    @Log(title = "查询角色", operationType = OperationTypeEnum.READ)
    public ServerResponse<RoleVO> getById(@PathVariable Long id) {
        var roleVO = roleService.readById(id);
        return ServerResponse.success(roleVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:getList')")
    @Log(title = "查询角色列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<RoleVO>> getListByPageAndParam(@Valid RoleParam roleParam) {
        var total = roleService.totalByParam(roleParam);
        var roles = roleService.readListByParam(roleParam);
        return ServerResponse.success(roles, total);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @GetMapping("/menu-tree")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:roles:menus:getTree')")
    @Log(title = "查询角色菜单树", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<MenuVO>> getMenuTree() {
        var menuTree = roleService.readMenuTree();
        return ServerResponse.success(menuTree);
    }
}
