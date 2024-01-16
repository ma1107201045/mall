package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/1 15:35
 * @description
 */
@Tag(name = "会员服务", description = "会员服务")
@RequiredArgsConstructor
@RestController
public class MemberFeignProvider implements MemberFeign {

    private final MemberService memberService;

    @Override
    public ServerResponse<Long> register(MemberRequest memberRequest) {
        Long id = memberService.register(memberRequest);
        return ServerResponse.success(id);
    }


    @Override
    public ServerResponse<MemberResponse> getByPhoneNumber(String phoneNumber) {
        MemberResponse memberResponse = memberService.readByPhoneNumber(phoneNumber);
        return ServerResponse.success(memberResponse);
    }
}
