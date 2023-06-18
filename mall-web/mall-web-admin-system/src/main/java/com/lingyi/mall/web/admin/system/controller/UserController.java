package com.lingyi.mall.web.admin.system.controller;

import com.github.pagehelper.Page;
import com.lingyi.mall.biz.system.dto.UserDTO;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
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
    @PreAuthorize("ps.hasAnyAuthority('admin:system:users:save')")
    @Log(title = "保存用户", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:users:delete')")
    @Log(title = "删除用户", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        userService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:users:update')")
    @Log(title = "更新用户", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.updateById(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('admin:system:users:get')")
    @Log(title = "查询用户", operationType = OperationTypeEnum.READ)
    public ServerResponse<UserVO> getById(@PathVariable Long id) {
        UserVO userVO = userService.readById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:users:getList')")
    @Log(title = "查询列表用户", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<UserVO>> getListByPageAndQuery(@Valid BasePageParam basePageParam, @Valid UserParam userParam) {
        Page<UserVO> page = PageUtil.startPage(basePageParam);
        List<UserVO> users = userService.readListByParam(userParam);
        return ServerResponse.success(users, page.getTotal());
    }


}
