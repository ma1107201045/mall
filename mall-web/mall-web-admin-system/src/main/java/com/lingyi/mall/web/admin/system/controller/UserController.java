package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.biz.system.dto.UserDTO;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.security.common.aspetct.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.jdbc.param.BasePageParam;
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
 * @DateTime: 2023/5/3 19:10
 * @Description:
 */
@Tag(name = "【系统管理服务-用户】", description = "【系统管理服务-用户】")
@RequestMapping("/admin/system/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:save')")
    @Log(title = "保存用户", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:delete')")
    @Log(title = "删除用户", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        userService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:update')")
    @Log(title = "更新用户", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.updateById(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:get')")
    @Log(title = "查询用户", operationType = OperationTypeEnum.READ)
    public ServerResponse<UserVO> getById(@PathVariable Long id) {
        var userVO = userService.readById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:getList')")
    @Log(title = "查询用户列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<UserVO>> getListByPageAndParam(@Valid UserParam userParam) {
        var total = userService.countByParam(userParam);
        var users = userService.readListByParam(userParam);
        return ServerResponse.success(users, total);
    }

    @Operation(summary = "查询角色列表", description = "查询角色列表")
    @GetMapping("/roles")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:roles:getList')")
    @Log(title = "查询角色列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<RoleVO>> getRoleList(@Valid BasePageParam basePageParam) {
        var roles = userService.readRoleList(basePageParam);
        return ServerResponse.success(roles);
    }

}
