package com.lingyi.mall.biz.system.provider.background;

import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.feign.MbsUserFeign;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/10 17:48
 * @description
 */
@Tag(name = "后台【系统管理服务-用户-Provider】", description = "后台【系统管理服务-用户-Provider】")
@RequiredArgsConstructor
@Validated
@RestController
public class MbsUserFeignProvider implements MbsUserFeign {

    private final MbsUserService mbsUserService;

    @Operation(summary = "查询用户和权限", description = "按照用户名称查询用户和权限")
    @Override
    public ServerResponse<UserVO> getUserAndMenuByUserName(@NotBlank(message = "用户名称不能为空") String userName) {
        UserVO userVO = mbsUserService.findUserAndMenuByUserNameAndMenuType(userName, MbsMenuType.BUTTON);
        return ServerResponse.success(userVO);
    }
}
