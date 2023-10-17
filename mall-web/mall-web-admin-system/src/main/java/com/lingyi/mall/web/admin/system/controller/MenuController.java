package com.lingyi.mall.web.admin.system.controller;

import com.lingyi.mall.biz.system.model.dto.MenuDTO;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.common.core.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
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
@Tag(name = "系统菜单", description = "系统菜单")
@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:menus:save')")
    @Log(title = "保存菜单", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody MenuDTO menuDTO) {
        menuService.create(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:menus:delete')")
    @Log(title = "删除/批量删除菜单", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        menuService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:menus:update')")
    @Log(title = "更新菜单", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDTO) {
        menuDTO.setId(id);
        menuService.updateById(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:menus:get')")
    @Log(title = "查询菜单", operationType = OperationTypeEnum.READ)
    public ServerResponse<MenuVO> getById(@PathVariable Long id) {
        var menuVO = menuService.readById(id);
        return ServerResponse.success(menuVO);
    }

    @Operation(summary = "查询树", description = "查询树")
    @GetMapping("/get-tree")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:menus:getTree')")
    @Log(title = "查询菜单树", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<MenuVO>> getTree() {
        var menus = menuService.readTree();
        return ServerResponse.success(menus);
    }

}
