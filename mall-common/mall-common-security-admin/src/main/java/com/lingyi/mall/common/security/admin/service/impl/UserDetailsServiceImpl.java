package com.lingyi.mall.common.security.admin.service.impl;

import com.lingyi.mall.api.system.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.base.entity.UserDetailsEntity;
import com.lingyi.mall.common.base.enums.YNEnum;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.admin.enums.McsaFailEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        AssertUtil.notBlack(username, new UsernameNotFoundException(McsaFailEnum.USER_NAME_NOT_NULL_ERROR.getMessage()));
        //查询用户信息和菜单权限
        UserVO userVO = mbsUserFeignConsumer.getUserAndMenuPermissionsByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userVO, new UsernameNotFoundException(McsaFailEnum.USER_NAME_NOT_FOUND_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userVO.getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        //更新用户登录时间
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
