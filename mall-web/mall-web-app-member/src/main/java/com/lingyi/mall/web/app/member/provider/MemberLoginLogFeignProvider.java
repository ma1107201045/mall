package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.api.member.feign.MemberLoginLogFeign;
import com.lingyi.mall.biz.member.service.MemberLoginLogService;
import com.lingyi.mall.common.base.util.ServerResponse;
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

    private final MemberLoginLogService memberLoginLogService;

    @Override
    public ServerResponse<Void> save(MemberLoginLogReqDTO memberLoginLogReqDTO) {
        memberLoginLogService.save(memberLoginLogReqDTO);
        return ServerResponse.success();
    }
}
