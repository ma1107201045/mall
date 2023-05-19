package com.lingyi.mall.biz.base.controller;

import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.biz.base.service.MbbService;
import com.lingyi.mall.common.base.util.AuthenticatorUtil;
import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/11 21:51
 * @Description:
 */
@Tag(name = "后台【基础服务-菜单】", description = "后台【基础服务-菜单】")
@Validated
@RequestMapping("/mbb")
@RestController
@RequiredArgsConstructor
public class MbbController {

    private final MbbService mbbService;

    @Operation(summary = "查询首页菜单信息", description = "查询首页菜单信息")
    @GetMapping("/menus")
    public ServerResponse<List<MenuVO>> getMenuTreeByUserId() {
        String userName = AuthenticatorUtil.getUserName();
        List<MenuVO> menuVoTree = mbbService.findMenuTreeByUserId(userName);
        return ServerResponse.success(menuVoTree);
    }
}