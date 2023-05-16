package com.lingyi.mall.biz.system.b.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.lingyi.mall.api.system.b.constant.MbsConstant;
import com.lingyi.mall.api.system.b.dto.MenuDTO;
import com.lingyi.mall.api.system.b.param.MenuParam;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.biz.system.b.service.MbsMenuService;
import com.lingyi.mall.common.bean.constant.BaseConstant;
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
@Tag(name = "【系统管理服务-菜单】", description = "【系统管理服务-菜单】")
@ApiSupport(order = 3, author = "maweiyan")
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
    @PreAuthorize("hasAnyAuthority('mbs:menu:getTree')")
    public ServerResponse<List<MenuVO>> getTree() {
        List<MenuVO> menus = mbsMenuService.findTreeByParentId(MbsConstant.MENU_ROOT_ID);
        return ServerResponse.success(menus);
    }

}
