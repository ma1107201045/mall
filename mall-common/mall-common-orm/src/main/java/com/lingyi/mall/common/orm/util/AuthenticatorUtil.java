package com.lingyi.mall.common.orm.util;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.extra.spring.SpringUtil;

import java.lang.reflect.Type;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 9:32
 * @Description:
 */
public class AuthenticatorUtil {


    public static Authenticator get() {
        CustomAuditorAware<Authenticator> bean = SpringUtil.getBean(new TypeReference<>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        return bean.getCurrentAuditor().orElse(new Authenticator());
    }

    public static Long currentUserId() {
        return get().getCurrentUserId();
    }

    public static String currentUserName() {
        return get().getCurrentUserName();
    }
}
