package com.lingyi.mall.biz.system.controller.background;

import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 19:10
 * @Description:
 */
@Tag(name = "用户", description = "用户")
@RequestMapping("/mbs/user")
@RestController
@RequiredArgsConstructor
public class MbsUserController {

    private final MbsUserService mbsUserService;

    @Operation(summary = "查询用户信息", description = "按照用户名称查询", hidden = true)
    @Parameter(description = "用户名称", required = true, example = "zhangsan")
    @GetMapping
    public ServerResponse<MbsUserVO> getByUserName(String userName) {
        return ServerResponse.success(mbsUserService.getByUserName(userName));
    }
}
