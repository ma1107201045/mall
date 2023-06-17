package com.lingyi.mall.web.admin.system.controller;

import com.github.pagehelper.Page;
import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.PageUtil;
import com.lingyi.mall.common.util.ServerResponse;
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
    @PreAuthorize("ps.hasAnyAuthority('admin:system:roles:save')")
    public ServerResponse<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:roles:delete')")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        roleService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:roles:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        roleService.updateById(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:roles:get')")
    public ServerResponse<RoleVO> getById(@PathVariable Long id) {
        RoleVO roleVO = roleService.readById(id);
        return ServerResponse.success(roleVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("ps.hasAnyAuthority('admin:system:roles:getList')")
    public ServerResponse<List<RoleVO>> getListByPageAndParam(@Valid BasePageParam basePageParam, @Valid RoleParam roleParam) {
        Page<RoleVO> page = PageUtil.startPage(basePageParam);
        List<RoleVO> roles = roleService.readListByParam(roleParam);
        return ServerResponse.success(roles, page.getTotal());
    }
}
