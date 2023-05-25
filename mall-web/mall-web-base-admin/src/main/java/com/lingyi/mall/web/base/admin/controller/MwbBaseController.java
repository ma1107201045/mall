package com.lingyi.mall.web.base.admin.controller;

import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.base.service.MbbService;
import com.lingyi.mall.common.base.util.AuthenticatorUtil;
import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:46
 * @description
 */
@Tag(name = "【系统基础服务】", description = "【系统基础服务】")
@RequestMapping("/mwb/admin/bases")
@RestController
@RequiredArgsConstructor
public class MwbBaseController {

    private final MbbService mbbService;

    @Operation(summary = "查询菜单", description = "查询菜单")
    @GetMapping("/menu")
    public ServerResponse<List<MenuVO>> getMenu() {
        String userName = AuthenticatorUtil.getUserName();
        List<MenuVO> menus = mbbService.findMenuTreeByUserName(userName);
        return ServerResponse.success(menus);
    }
}
