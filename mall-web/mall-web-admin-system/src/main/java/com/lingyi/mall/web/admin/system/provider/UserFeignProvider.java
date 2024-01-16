package com.lingyi.mall.web.admin.system.provider;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 19:55
 * @Description:
 */
@Tag(name = "provider-系统用户", description = "provider-系统日志")
@RequiredArgsConstructor
@RestController
public class UserFeignProvider implements UserFeign {

    private final UserService userService;

    @Operation(summary = "更新部分用户信息", description = "更新部分用户信息")
    @Override
    @SaCheckLogin
    public ServerResponse<Void> updatePartById(Long id, UserPartRequest userPartRequest) {
        userPartRequest.setId(id);
        userService.updatePartById(userPartRequest);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @Override
    @SaCheckLogin
    public ServerResponse<UserResponse> getUserByUserName(String userName) {
        var userResponse = userService.readUserByUserName(userName);
        return ServerResponse.success(userResponse);
    }

    @Operation(summary = "查询用户菜单树", description = "查询用户菜单树")
    @Override
    @SaCheckLogin
    public ServerResponse<List<MenuResponse>> getMenuTreesById(Long id) {
        var userResponse = userService.readMenuTreesById(id);
        return ServerResponse.success(userResponse);
    }

    @Operation(summary = "查询用户权限集", description = "查询用户权限集")
    @Override
    @SaCheckLogin
    public ServerResponse<List<String>> getMenuPermissionsById(Long id) {
        var permissions = userService.readMenuPermissionsById(id);
        return ServerResponse.success(permissions);
    }


}
