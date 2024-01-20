package com.lingyi.mall.security.core.util;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.extra.spring.SpringUtil;
import com.lingyi.mall.security.core.bean.Authenticator;

import java.lang.reflect.Type;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 9:32
 * @Description:
 */
public class AuthenticatorUtil {

    public static Authenticator getAuthenticator() {
        Aware<Authenticator> bean = SpringUtil.getBean(new TypeReference<>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        return bean.get();
    }

    public static Long getCurrentUserId() {
        return getAuthenticator().getCurrentUserId();
    }

    public static String getCurrentUserName() {
        return getAuthenticator().getCurrentUserName();
    }
}
