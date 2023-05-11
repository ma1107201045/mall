package com.lingyi.mall.biz.base.controller.background;

import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.common.bean.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/11 21:51
 * @Description:
 */
@Tag(name = "后台【基础服务-菜单】", description = "后台【基础服务-菜单】")
@RequiredArgsConstructor
@Validated
@RequestMapping("/mbb/menus")
@RestController
public class MbbMenuController {

    @Operation(summary = "查询", description = "查询")
    @GetMapping
    public ServerResponse<User> getList() {
        // User mbsUser = mbsUserService.findById(id);
        return ServerResponse.success(null);
    }
}