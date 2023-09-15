package com.lingyi.mall.security.app.util;

import com.lingyi.mall.security.core.util.Authenticator;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/22 23:41
 * @Description:
 */
@Component
public class AuthenticatorImpl implements Authenticator {
    @Override
    public Long getUserId() {
        return AuthenticatorUtil.getUserId();
    }

    @Override
    public String getUserName() {
        return AuthenticatorUtil.getUserName();
    }

    @Override
    public String getPhoneNumber() {
        return AuthenticatorUtil.getPhoneNumber();
    }
}
