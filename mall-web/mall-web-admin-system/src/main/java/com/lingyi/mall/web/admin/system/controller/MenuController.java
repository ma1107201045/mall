package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.service.MenuService;
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
@Tag(name = "【系统管理服务-菜单】", description = "【系统管理服务-菜单】")
@RequestMapping("/admin/system/menus")
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("ps.hasAnyAuthority('system:menu:save')")
    public ServerResponse<Void> save(@Valid @RequestBody MenuDTO menuDTO) {
        menuService.create(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("ps.hasAnyAuthority('system:menu:delete')")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        menuService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('system:menu:update')")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDTO) {
        menuDTO.setId(id);
        menuService.updateById(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("ps.hasAnyAuthority('system:menu:get')")
    public ServerResponse<MenuVO> getById(@PathVariable Long id) {
        MenuVO menuVO = menuService.readById(id);
        return ServerResponse.success(menuVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("ps.hasAnyAuthority('system:menu:getTree')")
    public ServerResponse<List<MenuVO>> getTree() {
        List<MenuVO> menus = menuService.findTreeByParentId(SystemConstant.MENU_ROOT_ID);
        return ServerResponse.success(menus);
    }

}
