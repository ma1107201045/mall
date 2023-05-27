package com.lingyi.mall.common.security.app.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.common.security.app.authentication.entity.MemberDetails;
import com.lingyi.mall.common.security.app.authentication.entity.MemberDetailsEntity;
import com.lingyi.mall.common.security.app.authentication.service.MemberDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 1:44
 * @Description:
 */
public class MemberDetailsServiceImpl implements MemberDetailsService {

    @Override
    public MemberDetails loadMemberByPhoneNumber(String phoneNumber) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.emptyList();
        return MemberDetailsEntity.builder()
                .authorities(simpleGrantedAuthorities)
                .phoneNumber("15038233127")
                .verificationCode(RandomUtil.randomNumbers(6))
                .enabled(true)
                .build();
    }
}
