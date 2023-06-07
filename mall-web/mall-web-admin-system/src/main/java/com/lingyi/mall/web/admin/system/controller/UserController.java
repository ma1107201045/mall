package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.query.UserQuery;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationType;
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
    @PreAuthorize("hasAnyAuthority('mws:user:save')")
    @Log(title = "保存用户", operationType = OperationType.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAnyAuthority('mws:user:remove')")
    @Log(title = "保存用户", operationType = OperationType.DELETE)
    public ServerResponse<Void> removeByIds(@PathVariable List<Long> ids) {
        userService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:user:update')")
    @Log(title = "保存用户", operationType = OperationType.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.updateById(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:user:get')")
    @Log(title = "保存用户", operationType = OperationType.READ)
    public ServerResponse<UserVO> getById(@PathVariable Long id) {
        UserVO userVO = userService.readById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('mws:user:getList')")
    @Log(title = "保存用户", operationType = OperationType.READ)
    public ServerResponse<List<UserVO>> getListByPageAndParam(@Valid BasePageQuery basePageQuery, @Valid UserQuery userQuery) {
        List<UserVO> userVOList = userService.readListByPageAndQuery(basePageQuery, userQuery);
        return ServerResponse.success(userVOList);
    }


}
