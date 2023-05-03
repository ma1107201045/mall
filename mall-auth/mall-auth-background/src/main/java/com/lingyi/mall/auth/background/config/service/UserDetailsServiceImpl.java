package com.lingyi.mall.auth.background.config.service;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.auth.background.entity.UserDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.util.collections.SingletonIterator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("zhangsan", passwordEncoder.encode("123456"), CollUtil.newArrayList(new SimpleGrantedAuthority("admin")));
    }
}
