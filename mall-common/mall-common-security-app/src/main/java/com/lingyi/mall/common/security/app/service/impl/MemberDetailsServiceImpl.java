package com.lingyi.mall.common.security.app.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.vo.MemberVO;
import com.lingyi.mall.common.base.entity.MemberDetails;
import com.lingyi.mall.common.base.entity.MemberDetailsEntity;
import com.lingyi.mall.common.base.enums.Whether;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.app.authentication.service.MemberDetailsService;
import com.lingyi.mall.common.security.app.enums.Fail;
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
        AssertUtil.notBlack(phoneNumber, new UsernameNotFoundException(Fail.PHONE_NUMBER_NOT_FOUND_ERROR.getMessage()));
        //查询用户信息和菜单权限
        MemberVO memberVO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
        //校验用用户信息
        AssertUtil.notNull(memberVO, new UsernameNotFoundException(Fail.PHONE_NUMBER_NOT_FOUND_ERROR.getMessage()));
        //ignore
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.emptyList();
        //组装MemberDetailsEntity
        return MemberDetailsEntity.builder()
                .authorities(simpleGrantedAuthorities)
                .phoneNumber(memberVO.getPhoneNumber())
                .verificationCode(RandomUtil.randomNumbers(6))
                .enabled(Whether.Y.getCode().equals(memberVO.getIsEnable()))
                .userId(memberVO.getMemberId())
                .userName(memberVO.getUserName())
                .build();
    }
}
