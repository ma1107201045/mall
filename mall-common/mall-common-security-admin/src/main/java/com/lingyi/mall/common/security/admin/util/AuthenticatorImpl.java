package com.lingyi.mall.common.security.admin.util;

import com.lingyi.mall.common.security.common.util.Authenticator;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/22 23:42
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
        return null;
    }

}
