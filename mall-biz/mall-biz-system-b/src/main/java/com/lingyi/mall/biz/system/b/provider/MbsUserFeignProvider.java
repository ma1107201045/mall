package com.lingyi.mall.biz.system.b.provider;

import com.lingyi.mall.api.system.b.constant.MbsConstant;
import com.lingyi.mall.api.system.b.feign.MbsUserFeign;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.api.system.b.vo.UserVO;
import com.lingyi.mall.biz.system.b.service.MbsUserService;
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
public class MbsUserFeignProvider implements MbsUserFeign {

    private final MbsUserService mbsUserService;

    @Operation(summary = "查询用户和权限标识", description = "查询用户和权限标识")
    @Override
    public ServerResponse<UserVO> getUserAndMenuPermissionsByUserName(String userName) {
        UserVO userVO = mbsUserService.findUserAndMenuPermissionsByUserName(userName);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询菜单树", description = "查询菜单树")
    @Override
    public ServerResponse<List<MenuVO>> getMenuTreeByUserName(String userName) {
        List<MenuVO> menuVoList = mbsUserService.findMenuTreeByUserNameAndMenuParentId(userName, MbsConstant.MENU_ROOT_ID);
        return ServerResponse.success(menuVoList);
    }

}