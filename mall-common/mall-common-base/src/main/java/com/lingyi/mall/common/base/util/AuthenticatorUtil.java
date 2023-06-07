package com.lingyi.mall.common.base.util;

import com.lingyi.mall.common.base.entity.MemberDetailsDO;
import com.lingyi.mall.common.base.entity.UserDetailsDO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:27
 * @Description:
 */
public class AuthenticatorUtil {


    private static Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
     * 获取app端用户认证信息
     *
     * @return UserDetailsEntity
     */
    public static MemberDetailsDO getMemberDetailsEntity() {
        return (MemberDetailsDO) getPrincipal();
    }

    /**
     * 获取当前认证用户id
     *
     * @return 用户id
     */
    public static Long getUserId() {
        return getPrincipal() instanceof UserDetailsDO ?
                getUserDetailsEntity().getUserId() :
                getMemberDetailsEntity().getUserId();
    }

    /**
     * 获取当前认证名用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        return getPrincipal() instanceof UserDetailsDO ?
                getUserDetailsEntity().getUsername() :
                getMemberDetailsEntity().getUserName();
    }
}
