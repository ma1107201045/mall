package com.lingyi.mall.common.security.b.service.impl;

import com.lingyi.mall.api.system.b.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.b.vo.UserVO;
import com.lingyi.mall.common.bean.entity.UserDetailsEntity;
import com.lingyi.mall.common.bean.enums.YNEnum;
import com.lingyi.mall.common.bean.util.AssertUtil;
import com.lingyi.mall.common.security.b.enums.McsFailEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:54
 * @description
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MbsUserFeignConsumer mbsUserFeignConsumer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //校验用户名称
        AssertUtil.notBlack(username, new UsernameNotFoundException(McsFailEnum.USER_NAME_NOT_NULL_ERROR.getMessage()));
        //查询用户信息和菜单权限
        UserVO userVO = mbsUserFeignConsumer.getUserAndMenuPermissionsByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userVO, new UsernameNotFoundException(McsFailEnum.USER_NAME_NOT_FOUND_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userVO.getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        //返回User
        return UserDetailsEntity.builder()
                .authorities(simpleGrantedAuthorities)
                .password(userVO.getPassword())
                .username(userVO.getUserName())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(YNEnum.Y.getCode().equals(userVO.getIsEnable()))
                .userId(userVO.getUserId())
                .build();
    }
}
