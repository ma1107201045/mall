package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.biz.member.model.entity.MemberDO;
import com.lingyi.mall.biz.member.model.entity.LevelDO;
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


    public MemberDO of(MemberRequest memberRequest) {
        var memberDO = ConverterUtil.to(memberRequest, MemberDO.class);
        var memberLevelDO = new LevelDO();
        memberLevelDO.setId(memberRequest.getMemberLevelId());
        memberDO.setLevelDO(memberLevelDO);
        return memberDO;
    }

}
