package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.query.MemberQuery;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.base.util.BaseService;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
public interface MemberService extends BaseService<MemberDO, MemberQuery, MemberVO, Long> {

    /**
     * 按照手机号查询
     *
     * @param phoneNumber 手机号
     * @return MemberVO
     */

    MemberVO findByPhoneNumber(String phoneNumber);

}
