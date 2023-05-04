package com.lingyi.mall.auth.background.service.Impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.auth.background.enums.MabFailEnum;
import com.lingyi.mall.common.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:54
 * @description
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final MbsUserFeignConsumer mbsUserFeignConsumer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MbsUserVO vo = mbsUserFeignConsumer.getByUserName(username);
        AssertUtil.notNull(vo, new UsernameNotFoundException(MabFailEnum.USER_NAME_NOT_FOUND_ERROR.getMsg()));
        return new User(username, vo.getPassword(), CollUtil.newArrayList(new SimpleGrantedAuthority("admin")));
    }
}
