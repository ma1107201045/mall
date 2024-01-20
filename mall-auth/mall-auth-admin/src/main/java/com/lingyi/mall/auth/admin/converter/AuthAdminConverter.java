package com.lingyi.mall.auth.admin.converter;

import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.auth.admin.model.vo.AuthenticatorVO;
import com.lingyi.mall.security.admin.bean.AdminAuthenticator;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/20 9:45
 * @Description:
 */
public class AuthAdminConverter {


    public static final AuthAdminConverter INSTANCE = new AuthAdminConverter();

    public AdminAuthenticator toAdminAuthenticator(UserResponse userResponse) {
        AdminAuthenticator adminAuthenticator = new AdminAuthenticator();
        adminAuthenticator.setCurrentUserId(userResponse.getUserId());
        adminAuthenticator.setCurrentUserName(userResponse.getUserName());
        adminAuthenticator.setUserId(userResponse.getUserId());
        return adminAuthenticator;
    }

    public AuthenticatorVO toAuthenticatorVO(UserResponse userResponse) {
        AuthenticatorVO adminAuthenticator = new AuthenticatorVO();
        adminAuthenticator.setUserId(userResponse.getUserId());
        return adminAuthenticator;
    }
}
