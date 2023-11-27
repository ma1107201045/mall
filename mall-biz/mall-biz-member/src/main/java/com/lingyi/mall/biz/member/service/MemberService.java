package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.biz.member.model.dto.MemberDTO;
import com.lingyi.mall.biz.member.model.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.model.entity.MemberDO;
import com.lingyi.mall.biz.member.model.param.MemberParam;
import com.lingyi.mall.biz.member.model.vo.MemberVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
public interface MemberService extends BaseServicePro<MemberDTO, MemberVO, MemberParam, MemberDO, Long> {

    /**
     * 更新会员是否启用字段
     *
     * @param memberPartDTO ..
     */
    void updateIsEnableById(MemberPartDTO memberPartDTO);

    /**
     * 注册会员
     *
     * @param memberRequest 。。
     * @return Long 会员id
     */
    Long register(MemberRequest memberRequest);

    /**
     * 按照手机号查询
     *
     * @param phoneNumber 手机号
     * @return MemberRespDTO ..
     */

    MemberResponse readByPhoneNumber(String phoneNumber);

}
