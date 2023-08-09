package com.lingyi.mall.common.security.admin.service.impl;

import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.admin.entity.UserDetailsDO;
import com.lingyi.mall.common.security.admin.enums.FailEnum;
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

    private final UserFeignConsumer userFeignConsumer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //校验用户名称
        AssertUtil.notBlack(username, new UsernameNotFoundException(FailEnum.USER_NAME_NOT_NULL_ERROR.getMessage()));
        //查询用户信息和菜单权限
        UserRespDTO userDTO = userFeignConsumer.getUserAndMenuPermissionsByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userDTO, new UsernameNotFoundException(FailEnum.USER_NAME_NOT_FOUND_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userDTO.getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        //组装UserDetailsEntity
        return UserDetailsDO.builder()
                .authorities(simpleGrantedAuthorities)
                .password(userDTO.getPassword())
                .username(userDTO.getUserName())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(WhetherEnum.Y.getCode().equals(userDTO.getIsEnable()))
                .userId(userDTO.getUserId())
                .build();
    }
}
