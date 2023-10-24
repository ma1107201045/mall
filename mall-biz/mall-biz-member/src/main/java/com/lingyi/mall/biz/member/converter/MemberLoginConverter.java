package com.lingyi.mall.biz.member.converter;

import com.lingyi.mall.api.member.dto.LoginLogReqDTO;
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

    public MemberLoginLogDO of(LoginLogReqDTO loginLogReqDTO) {
        var memberLoginLogDO = ConverterUtil.to(loginLogReqDTO, MemberLoginLogDO.class);
        var memberDO = new MemberDO();
        memberDO.setId(loginLogReqDTO.getMemberId());
        memberLoginLogDO.setMemberDO(memberDO);
        return memberLoginLogDO;
    }
}
