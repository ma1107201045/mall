package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.core.util.ServerResponse;
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

    @Operation(summary = "更新当前用户部分信息", description = "更新用户部分信息")
    @Override
    public ServerResponse<Void> updatePartById(Long id, UserPartReqDTO userPartReqDTO) {
        userPartReqDTO.setId(id);
        userService.updatePartById(userPartReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询当前用户信息和权限标识", description = "查询当前用户信息和权限标识")
    @Override
    public ServerResponse<UserRespDTO> getUserAndMenuPermissionsByUserName(String userName) {
        var userRespDTO = userService.readUserAndMenuPermissionsByUserName(userName);
        return ServerResponse.success(userRespDTO);
    }

    @Operation(summary = "查询当前用户菜单树", description = "查询菜单树")
    @Override
    public ServerResponse<List<MenuRespDTO>> getMenuTreesByUserName(String userName) {
        var menus = userService.readMenuTreesByUserName(userName);
        return ServerResponse.success(menus);
    }

    @Operation(summary = "查询当前用户权限集", description = "查询权限集")
    @Override
    public ServerResponse<List<String>> getMenuPermissionsByUserName(String userName) {
        var permissions = userService.readMenuPermissionsByUserName(userName);
        return ServerResponse.success(permissions);
    }
}
