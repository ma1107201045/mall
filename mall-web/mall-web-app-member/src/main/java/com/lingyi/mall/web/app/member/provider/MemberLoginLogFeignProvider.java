package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.dto.LoginLogReqDTO;
import com.lingyi.mall.api.member.feign.MemberLoginLogFeign;
import com.lingyi.mall.biz.member.service.LoginLogService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 14:57
 * @description
 */
@Tag(name = "会员登录日志", description = "会员登录日志")
@RequiredArgsConstructor
@RestController
public class MemberLoginLogFeignProvider implements MemberLoginLogFeign {

    private final LoginLogService loginLogService;

    @Override
    public ServerResponse<Void> save(LoginLogReqDTO loginLogReqDTO) {
        loginLogService.save(loginLogReqDTO);
        return ServerResponse.success();
    }
}
