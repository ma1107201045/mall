package com.lingyi.mall.auth.background.service.Impl;

import com.lingyi.mall.api.system.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.auth.background.enums.MabFailEnum;
import com.lingyi.mall.common.enums.YNEnum;
import com.lingyi.mall.common.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:54
 * @description
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MbsUserFeignConsumer mbsUserFeignConsumer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //校验用户名称
        AssertUtil.notBlack(username, new UsernameNotFoundException(MabFailEnum.USER_NAME_NOT_NULL_ERROR.getMessage()));
        //查询用户信息和菜单权限
        UserVO userVO = mbsUserFeignConsumer.getUserAndMenuByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userVO, new UsernameNotFoundException(MabFailEnum.USER_NAME_NOT_FOUND_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userVO.getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        //返回User
        return User.builder()
                .username(userVO.getUserName())
                .password(userVO.getPassword())
                .authorities(simpleGrantedAuthorities)
                .disabled(YNEnum.N.getCode().equals(userVO.getIsEnable()))
                .build();
    }
}
