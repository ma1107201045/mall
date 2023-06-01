package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.vo.MemberVO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
public interface MemberService {


    MemberVO findByPhoneNumber(String phoneNumber);

}
