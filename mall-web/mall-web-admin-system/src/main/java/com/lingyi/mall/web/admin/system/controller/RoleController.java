package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.query.RoleQuery;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.base.query.BasePageQuery;
import com.lingyi.mall.common.base.util.ServerResponse;
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
    @PreAuthorize("hasAnyAuthority('mws:role:save')")
    public ServerResponse<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        roleService.create(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAnyAuthority('mws:role:delete')")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        roleService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:role:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        roleService.updateById(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:role:get')")
    public ServerResponse<RoleVO> getById(@PathVariable Long id) {
        RoleVO roleVO = roleService.readById(id);
        return ServerResponse.success(roleVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('mbs:role:getList')")
    public ServerResponse<List<RoleVO>> getListByPageAndParam(@Valid BasePageQuery basePageQuery, @Valid RoleQuery roleQuery) {
        List<RoleVO> roles = roleService.readListByPageAndQuery(basePageQuery, roleQuery);
        return ServerResponse.success(roles);
    }
}
