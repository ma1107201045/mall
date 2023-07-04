package com.lingyi.mall.common.security.admin.entity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:27
 * @Description:
 */
public class AuthenticatorUtil {


    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Object getPrincipal() {
        return getAuthentication().getPrincipal();
    }


    public static Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthentication().getAuthorities();
    }

    /**
     * 获取admin端用户认证信息
     *
     * @return UserDetailsEntity
     */
    public static UserDetailsDO getUserDetailsEntity() {
        return (UserDetailsDO) getPrincipal();
    }


    /**
     * 获取当前认证用户id
     *
     * @return 用户id
     */
    public static Long getUserId() {
        return getUserDetailsEntity().getUserId();
    }

    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        return getUserDetailsEntity().getUsername();
    }
}
