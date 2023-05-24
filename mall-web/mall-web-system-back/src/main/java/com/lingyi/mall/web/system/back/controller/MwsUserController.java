package com.lingyi.mall.web.system.back.controller;

import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.param.UserParam;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.base.param.BasePageParam;
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
@RequestMapping("/mws/back/users")
@RestController
@RequiredArgsConstructor
public class MwsUserController {

    private final MbsUserService mbsUserService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("hasAnyAuthority('mws:user:save')")
    public ServerResponse<Void> save(@Valid @RequestBody UserDTO userDTO) {
        mbsUserService.add(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAnyAuthority('mws:user:remove')")
    public ServerResponse<Void> removeByIds(@PathVariable List<Long> ids) {
        mbsUserService.removeByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:user:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        mbsUserService.editById(userDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mws:user:get')")
    public ServerResponse<UserVO> getById(@PathVariable Long id) {
        UserVO userVO = mbsUserService.findById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('mws:user:getList')")
    public ServerResponse<List<UserVO>> getListByPageAndParam(@Valid BasePageParam basePageParam, @Valid UserParam userParam) {
        List<UserVO> userVOList = mbsUserService.findListByPageAndParam(basePageParam, userParam);
        return ServerResponse.success(userVOList);
    }


}
