package com.lingyi.mall.auth.admin.converter;

import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.auth.admin.model.vo.AuthAdminVO;
import com.lingyi.mall.security.admin.bean.AdminAuthenticator;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/20 9:45
 * @Description:
 */
public class AuthAdminConverter {


    private AuthAdminConverter() {

    }

    public static final AuthAdminConverter INSTANCE = new AuthAdminConverter();

    public AdminAuthenticator toAdminAuthenticator(UserResponse response) {
        var adminAuthenticator = new AdminAuthenticator();
        adminAuthenticator.setCurrentUserId(response.getUserId());
        adminAuthenticator.setCurrentUserName(response.getUserName());
        adminAuthenticator.setUserId(response.getUserId());
        return adminAuthenticator;
    }

    public AuthAdminVO toAuthenticatorVO(UserResponse response) {
        var adminAuthenticator = new AuthAdminVO();
        adminAuthenticator.setUserId(response.getUserId());
        return adminAuthenticator;
    }
}
