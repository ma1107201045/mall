package com.lingyi.mall.biz.system.provider.background;

import com.lingyi.mall.api.system.feign.MbsUserFeign;
import com.lingyi.mall.api.system.vo.MenuTreeVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
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
public class MbsUserFeignProvider implements MbsUserFeign {

    private final MbsUserService mbsUserService;


    @Operation(summary = "查询用户和按钮权限标识", description = "查询用户和按钮权限标识")
    @Override
    public ServerResponse<UserVO> getUserAndButtonByUserName(String userName) {
        UserVO userVO = mbsUserService.findUserAndButtonByUserName(userName);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询用户菜单", description = "查询用户菜单")
    @Override
    public ServerResponse<List<MenuTreeVO>> getDirectoryAndMenuByUserName(String userName) {

        return ServerResponse.success(null);
    }

}
