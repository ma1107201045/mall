package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.UserService;
import com.lingyi.mall.common.base.util.ServerResponse;
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
    public ServerResponse<Void> updatePartById(Long id, UserPartDTO userPartDTO) {
        userPartDTO.setId(id);
        userService.editPartById(userPartDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询用户和权限标识", description = "查询用户和权限标识")
    @Override
    public ServerResponse<UserVO> getUserAndMenuPermissionsByUserName(String userName) {
        UserVO userVO = userService.findUserAndMenuPermissionsByUserName(userName);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @Override
    public ServerResponse<List<MenuVO>> getMenuTreeByUserName(String userName) {
        List<MenuVO> menuVoList = userService.findMenuTreeByUserNameAndMenuParentId(userName, SystemConstant.MENU_ROOT_ID);
        return ServerResponse.success(menuVoList);
    }

}
