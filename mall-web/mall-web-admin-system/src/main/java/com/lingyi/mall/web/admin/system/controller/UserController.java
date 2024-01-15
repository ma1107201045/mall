package com.lingyi.mall.web.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lingyi.mall.biz.system.model.dto.UserDTO;
import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.query.UserQuery;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.biz.system.model.vo.UserVO;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
import com.lingyi.mall.common.log.enums.OperationTypeEnum;
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
 * @DateTime: 2023/5/3 19:10
 * @Description:
 */
@Tag(name = "系统用户", description = "系统用户")
@RestController
@RequestMapping("/users")
@SaCheckLogin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:save")
    @Log(title = "保存用户", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:delete")
    @Log(title = "删除用户", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        userService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:update")
    @Log(title = "更新用户", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.updateById(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:get")
    @Log(title = "查询用户", operationType = OperationTypeEnum.READ)
    public ServerResponse<UserVO> getById(@PathVariable Long id) {
        var userVO = userService.readById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:getList")
    @Log(title = "查询用户列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<UserVO>> getListByPageAndParam(@Valid UserQuery userParam) {
        var total = userService.totalByParam(userParam);
        var users = userService.readListByParam(userParam);
        return ServerResponse.success(users, total);
    }

    @Operation(summary = "查询角色列表", description = "查询角色列表")
    @GetMapping("/roles")
    @SaCheckLogin
    @SaCheckPermission("admin:system:users:roles:getList")
    @Log(title = "查询角色列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<RoleVO>> getRoleList(@Valid RoleQuery roleQuery) {
        var roles = userService.readRoleList(roleQuery);
        return ServerResponse.success(roles);
    }

}
