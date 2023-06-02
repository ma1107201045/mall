package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.entity.Member;
import com.lingyi.mall.api.member.vo.MemberVO;
import com.lingyi.mall.common.base.util.BaseService;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
public interface MemberService extends BaseService<Member, Member, Member, Long> {


    MemberVO findByPhoneNumber(String phoneNumber);

}
