package com.lingyi.mall.web.admin.system.provider;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
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

@RestController
@SaCheckLogin
@RequiredArgsConstructor
public class UserFeignProvider implements UserFeign {

    private final UserService userService;


    @Override
    public ServerResponse<Void> updatePartById(Long id, UserPartRequest userPartRequest) {
        userPartRequest.setId(id);
        userService.updatePartById(userPartRequest);
        return ServerResponse.success();
    }


    @SaIgnore
    @Override
    public ServerResponse<UserResponse> getUserByUserName(String userName) {
        var userResponse = userService.readUserByUserName(userName);
        return ServerResponse.success(userResponse);
    }


    @Override
    public ServerResponse<List<MenuResponse>> getMenuTreesById(Long id) {
        var userResponse = userService.readMenuTreesById(id);
        return ServerResponse.success(userResponse);
    }

    @Override
    public ServerResponse<List<String>> getMenuPermissionsById(Long id) {
        var permissions = userService.readMenuPermissionsById(id);
        return ServerResponse.success(permissions);
    }


}
