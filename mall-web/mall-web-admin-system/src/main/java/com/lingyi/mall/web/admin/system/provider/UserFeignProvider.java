package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserResDTO;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.util.ServerResponse;
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
@Tag(name = "后台【系统管理服务-用户-Provider】", description = "后台【系统管理服务-用户-Provider】")
@RequiredArgsConstructor
@RestController
public class UserFeignProvider implements UserFeign {

    private final UserService userService;

    @Operation(summary = "更新用户部分信息", description = "更新用户部分信息")
    @Override
    public ServerResponse<Void> updatePartById(Long id, UserPartReqDTO userPartReqDTO) {
        userPartReqDTO.setId(id);
        userService.updatePartById(userPartReqDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询用户和权限标识", description = "查询用户和权限标识")
    @Override
    public ServerResponse<UserResDTO> getUserAndMenuPermissionsByUserName(String userName) {
        UserResDTO userResDTO = userService.readUserAndMenuPermissionsByUserName(userName);
        return ServerResponse.success(userResDTO);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @Override
    public ServerResponse<List<MenuResDTO>> getMenuTreeByUserName(String userName) {
        List<MenuResDTO> menuResDTOList = userService.readMenuTreeByUserNameAndMenuParentId(userName, SystemConstant.MENU_ROOT_ID);
        return ServerResponse.success(menuResDTOList);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @Override
    public ServerResponse<List<String>> getMenuPermissionsByUserIdAndUserName(Long userId, String userName) {
        List<String> permissions = userService.readMenuPermissionsByUserIdAndUserName(userId, userName);
        return ServerResponse.success(permissions);
    }
}
