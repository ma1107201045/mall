package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.biz.member.dto.MemberDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLevelDO;

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


    public MemberDO of(MemberDTO memberDTO) {
        var memberDO = new MemberDO();
        var memberLevelDO = new MemberLevelDO();
        memberLevelDO.setId(memberDTO.getMemberLevelId());
        memberDO.setMemberLevelDO(memberLevelDO);
        return memberDO;
    }

}
