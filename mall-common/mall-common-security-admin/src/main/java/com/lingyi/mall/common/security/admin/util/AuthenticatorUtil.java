package com.lingyi.mall.common.security.admin.util;

import com.lingyi.mall.common.security.admin.constant.SecurityConstant;
import com.lingyi.mall.common.security.admin.entity.UserDetailsDO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Collections;

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

    /**
     * 获取admin端用户认证信息
     *
     * @return UserDetailsEntity
     */
    public static UserDetailsDO getUserDetailsDO() {
        var principal = getAuthentication().getPrincipal();
        return principal instanceof UserDetailsDO userDetailsDO ? userDetailsDO :
                UserDetailsDO.builder()
                        .userId(-1L)
                        .username(SecurityConstant.UNKNOWN)
                        .authorities(Collections.emptyList())
                        .build();
    }

    /**
     * 获取当前认证用户id
     *
     * @return 用户id
     */
    public static Long getUserId() {
        return getUserDetailsDO().getUserId();
    }

    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        return getUserDetailsDO().getUsername();
    }

    public static Collection<? extends GrantedAuthority> getAuthorities() {
        return getUserDetailsDO().getAuthorities();
    }
}
