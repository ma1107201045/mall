package com.lingyi.mall.common.security.admin.service.impl;

import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.base.entity.UserDetailsDO;
import com.lingyi.mall.common.base.enums.Whether;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.security.admin.enums.Fail;
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
        AssertUtil.notBlack(username, new UsernameNotFoundException(Fail.USER_NAME_NOT_NULL_ERROR.getMessage()));
        //查询用户信息和菜单权限
        UserVO userVO = userFeignConsumer.getUserAndMenuPermissionsByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userVO, new UsernameNotFoundException(Fail.USER_NAME_NOT_FOUND_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = userVO.getPermissions().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        //组装UserDetailsEntity
        return UserDetailsDO.builder()
                .authorities(simpleGrantedAuthorities)
                .password(userVO.getPassword())
                .username(userVO.getUserName())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(Whether.Y.getCode().equals(userVO.getIsEnable()))
                .userId(userVO.getUserId())
                .build();
    }
}
