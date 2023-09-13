package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.biz.member.dto.MemberDTO;
import com.lingyi.mall.biz.member.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.orm.util.BaseService;
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
     * @param memberReqDTO 。。
     * @return Long 会员id
     */
    Long register(MemberReqDTO memberReqDTO);

    /**
     * 按照手机号查询
     *
     * @param phoneNumber 手机号
     * @return MemberVO
     */

    MemberRespDTO readByPhoneNumber(String phoneNumber);

}
