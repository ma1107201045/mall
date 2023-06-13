package com.lingyi.mall.common.security.app.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.common.base.entity.MemberDetails;
import com.lingyi.mall.common.base.entity.MemberDetailsDO;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.app.service.MemberDetailsService;
import com.lingyi.mall.common.security.app.enums.FailEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/27 1:44
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements MemberDetailsService {

    private final MemberFeignConsumer memberFeignConsumer;

    @Override
    public MemberDetails loadMemberByPhoneNumber(String phoneNumber) throws UsernameNotFoundException {
        //校验用户名称
        AssertUtil.notBlack(phoneNumber, new UsernameNotFoundException(FailEnum.PHONE_NUMBER_NOT_FOUND_ERROR.getMessage()));
        //查询用户信息和菜单权限
        MemberReqDTO memberDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
        //校验用用户信息
        AssertUtil.notNull(memberDTO, new UsernameNotFoundException(FailEnum.PHONE_NUMBER_NOT_FOUND_ERROR.getMessage()));
        //ignore
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.emptyList();
        //组装MemberDetailsEntity
        return MemberDetailsDO.builder()
                .authorities(simpleGrantedAuthorities)
                .phoneNumber(memberDTO.getPhoneNumber())
                .verificationCode(RandomUtil.randomNumbers(6))
                .enabled(WhetherEnum.Y.getCode().equals(memberDTO.getIsEnable()))
                .userId(memberDTO.getMemberId())
                .userName(memberDTO.getUserName())
                .build();
    }
}
