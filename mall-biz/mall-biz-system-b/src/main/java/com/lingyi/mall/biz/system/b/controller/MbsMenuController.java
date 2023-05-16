package com.lingyi.mall.biz.system.b.controller;

import com.lingyi.mall.api.system.b.dto.MenuDTO;
import com.lingyi.mall.api.system.b.param.MenuParam;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.biz.system.b.service.MbsMenuService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import com.lingyi.mall.common.bean.util.ServerResponse;
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
@Tag(name = "后台【系统管理服务-菜单】", description = "后台【系统管理服务-菜单】")
@RequestMapping("/mbs/b/menus")
@RestController
@RequiredArgsConstructor
public class MbsMenuController {

    private final MbsMenuService mbsMenuService;


    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("hasAnyAuthority('mbs:menu:save')")
    public ServerResponse<Void> save(@Valid @RequestBody MenuDTO menuDTO) {
        mbsMenuService.add(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAnyAuthority('mbs:menu:remove')")
    public ServerResponse<Void> removeByIds(@PathVariable Iterable<Long> ids) {
        mbsMenuService.removeByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mbs:menu:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDTO) {
        menuDTO.setId(id);
        mbsMenuService.editById(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('mbs:menu:get')")
    public ServerResponse<MenuVO> getById(@PathVariable Long id) {
        MenuVO menuVO = mbsMenuService.findById(id);
        return ServerResponse.success(menuVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('mbs:menu:getList')")
    public ServerResponse<List<MenuVO>> getListByPageAndParam(@Valid BasePageParam basePageParam, @Valid MenuParam menuParam) {
        List<MenuVO> menus = mbsMenuService.findListByPageAndParam(basePageParam, menuParam);
        return ServerResponse.success(menus);
    }

}
