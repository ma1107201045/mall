package com.lingyi.mall.web.app.member.provider;

import com.lingyi.mall.api.member.dto.MemberDTO;
import com.lingyi.mall.api.member.feign.MemberFeign;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/1 15:35
 * @description
 */
@Tag(name = "前台【会员服务-用户-Provider】", description = "前台【会员服务-用户-Provider】")
@RequiredArgsConstructor
@RestController
public class MemberProvider implements MemberFeign {

    private final MemberService mbmMemberService;

    @Override
    public ServerResponse<MemberDTO> getByPhoneNumber(String phoneNumber) {
        MemberVO memberVO = mbmMemberService.findByPhoneNumber(phoneNumber);
        return ServerResponse.success(null);
    }
}
