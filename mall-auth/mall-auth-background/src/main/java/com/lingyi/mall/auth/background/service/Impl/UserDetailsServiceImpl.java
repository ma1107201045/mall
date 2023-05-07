package com.lingyi.mall.auth.background.service.Impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.auth.background.enums.MabFailEnum;
import com.lingyi.mall.common.security.CustomizeGrantedAuthority;
import com.lingyi.mall.common.util.AssertUtil;
import lombok.RequiredArgsConstructor;
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
        //查询用户信息和菜单权限
        UserVO userVO = mbsUserFeignConsumer.getUserAndMenuByUserName(username);
        //校验用用户信息
        AssertUtil.notNull(userVO, new UsernameNotFoundException(MabFailEnum.USER_NAME_NOT_EXIST_ERROR.getMessage()));
        //获取菜单权限中的权限标识
        List<String> permissions = userVO.getMenuVOList()
                .stream()
                .map(MenuVO::getPermission)
                .toList();
        //返回User
        return User.builder()
                .username(username)
                .password(userVO.getPassword())
                .authorities(CollUtil.newArrayList(CustomizeGrantedAuthority.of(permissions)))
                .build();
    }
}
