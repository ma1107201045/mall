package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.biz.member.dto.MemberLoginLogDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
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

    public MemberLoginLogDO of(MemberLoginLogReqDTO memberLoginLogReqDTO) {
        var memberLoginLogDO = ConverterUtil.to(memberLoginLogReqDTO, MemberLoginLogDO.class);
        var memberDO = new MemberDO();
        memberDO.setId(memberLoginLogReqDTO.getMemberId());
        memberLoginLogDO.setMemberDO(memberDO);
        return memberLoginLogDO;
    }
}
