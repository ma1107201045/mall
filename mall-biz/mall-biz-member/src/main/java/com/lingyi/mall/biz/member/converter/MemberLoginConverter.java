package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.api.member.reqeust.MemberLoginLogRequest;
import com.lingyi.mall.biz.member.model.entity.MemberDO;
import com.lingyi.mall.biz.member.model.entity.MemberLoginLogDO;
import com.lingyi.mall.common.core.util.ConverterUtil;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/13 9:49
 * @Description:
 */
public class MemberLoginConverter {

    public static final MemberLoginConverter INSTANCE = new MemberLoginConverter();

    private MemberLoginConverter() {

    }

    public MemberLoginLogDO of(MemberLoginLogRequest memberLoginLogRequest) {
        var memberLoginLogDO = ConverterUtil.to(memberLoginLogRequest, MemberLoginLogDO.class);
        var memberDO = new MemberDO();
        memberDO.setId(memberLoginLogRequest.getMemberId());
        memberLoginLogDO.setMemberDO(memberDO);
        return memberLoginLogDO;
    }
}
