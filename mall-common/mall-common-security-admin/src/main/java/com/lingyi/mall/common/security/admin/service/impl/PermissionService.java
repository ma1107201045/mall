package com.lingyi.mall.common.security.admin.service.impl;

import com.lingyi.mall.common.base.util.AuthenticatorUtil;
import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/16 10:18
 * @description
 */
@Component("ps")
public class PermissionService {

    /**
     * 当前用户是否具有权限
     *
     * @param permission 权限标识
     * @return 结果
     */
    public boolean hasAnyAuthority(String permission) {
        return AuthenticatorUtil.getAuthorities().stream()
                .flatMap(grantedAuthority -> Arrays.stream(grantedAuthority.getAuthority()
                        .split(SecurityAdminConstant.PERMISSION_SPLIT_CHAR)))
                .anyMatch(item -> item.equals(permission));

    }

}
