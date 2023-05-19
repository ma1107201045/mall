package com.lingyi.mall.biz.system.b.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.lingyi.mall.api.system.b.dto.RoleDTO;
import com.lingyi.mall.api.system.b.param.RoleParam;
import com.lingyi.mall.api.system.b.vo.RoleVO;
import com.lingyi.mall.biz.system.b.service.MbsRoleService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import com.lingyi.mall.common.bean.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/16 21:18
 * @Description:
 */
@Tag(name = "【系统管理服务-角色】", description = "【系统管理服务-角色】")
@RequestMapping("/mbs/b/roles")
@RestController
@RequiredArgsConstructor
public class MbsRoleController {

    private final MbsRoleService mbsRoleService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("hasAnyAuthority('mbs:role:save')")
    public ServerResponse<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        mbsRoleService.add(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAnyAuthority('mbs:role:remove')")
    public ServerResponse<Void> removeByIds(@PathVariable List<Long> ids) {
        mbsRoleService.removeByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mbs:role:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        mbsRoleService.editById(roleDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mbs:role:get')")
    public ServerResponse<RoleVO> getById(@PathVariable Long id) {
        RoleVO roleVO = mbsRoleService.findById(id);
        return ServerResponse.success(roleVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('mbs:role:getList')")
    public ServerResponse<List<RoleVO>> getListByPageAndParam(@Valid BasePageParam basePageParam, @Valid RoleParam roleParam) {
        List<RoleVO> roles = mbsRoleService.findListByPageAndParam(basePageParam, roleParam);
        return ServerResponse.success(roles);
    }
}
