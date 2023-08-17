package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.base.util.ServerResponse;
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
    public ServerResponse<Long> register(MemberReqDTO memberReqDTO) {
        Long id = memberService.register(memberReqDTO);
        return ServerResponse.success(id);
    }


    @Override
    public ServerResponse<MemberRespDTO> getByPhoneNumber(String phoneNumber) {
        MemberRespDTO memberRespDTO = memberService.readByPhoneNumber(phoneNumber);
        return ServerResponse.success(memberRespDTO);
    }
}
