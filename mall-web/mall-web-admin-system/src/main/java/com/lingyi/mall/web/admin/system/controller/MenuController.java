package com.lingyi.mall.web.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lingyi.mall.biz.system.model.dto.MenuDTO;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
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
 * @DateTime: 2023/5/16 21:18
 * @Description:
 */
@Tag(name = "系统菜单", description = "系统菜单")
@RestController
@RequestMapping("/menus")
@SaCheckLogin
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckPermission("admin:system:menus:save")
    public ServerResponse<Void> save(@Valid @RequestBody MenuDTO menuDTO) {
        menuService.create(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckPermission("admin:system:menus:delete")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        menuService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckPermission("admin:system:menus:update")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDTO) {
        menuDTO.setId(id);
        menuService.updateByDTO(menuDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckPermission("admin:system:menus:get")
    public ServerResponse<MenuVO> getById(@PathVariable Long id) {
        var menuVO = menuService.readById(id);
        return ServerResponse.success(menuVO);
    }

    @Operation(summary = "查询树", description = "查询树")
    @GetMapping("/get-tree")
    @SaCheckPermission("admin:system:menus:getTree")
    public ServerResponse<List<MenuVO>> getTree() {
        var menus = menuService.readTree();
        return ServerResponse.success(menus);
    }

}
