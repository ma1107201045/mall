package com.lingyi.mall.biz.member.service;

import com.lingyi.mall.api.member.dto.MemberDTO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
public interface MbmMemberService {


    /**
     * 注册
     *
     * @param memberRegisterDTO 注册DTO
     */
    void register(MemberDTO memberRegisterDTO);

    void loginOfPhoneNumber();
}
