package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.biz.member.dto.MemberDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.common.core.util.ConverterUtil;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/12 14:39
 * @Description:
 */
public class MemberConverter {

    public static final MemberConverter INSTANCE = new MemberConverter();

    private MemberConverter() {

    }


    public MemberDO of(MemberReqDTO memberReqDTO) {
        var memberDO = ConverterUtil.to(memberReqDTO, MemberDO.class);
        var memberLevelDO = new MemberLevelDO();
        memberLevelDO.setId(memberReqDTO.getMemberLevelId());
        memberDO.setMemberLevelDO(memberLevelDO);
        return memberDO;
    }

}
