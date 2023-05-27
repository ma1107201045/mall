package com.lingyi.mall.common.security.app.authentication.service;

import com.lingyi.mall.common.security.app.authentication.entity.MemberDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 1:09
 * @Description:
 */
public interface MemberDetailsService {

    /**
     * 按照手机号查询会员信息
     *
     * @param phoneNumber 手机号
     * @return MemberDetails
     * @throws UsernameNotFoundException
     */
    MemberDetails loadMemberByPhoneNumber(String phoneNumber) throws UsernameNotFoundException;
}
