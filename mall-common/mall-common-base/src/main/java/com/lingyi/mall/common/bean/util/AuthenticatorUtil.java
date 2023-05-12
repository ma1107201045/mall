package com.lingyi.mall.common.bean.util;

import com.lingyi.mall.common.bean.entity.UserDetailsEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:27
 * @Description:
 */
public class AuthenticatorUtil {


    /**
     * 获取当前用户认证信息
     *
     * @return UserDetailsEntity
     */
    public static UserDetailsEntity getUserDetailsEntity() {
        return (UserDetailsEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
