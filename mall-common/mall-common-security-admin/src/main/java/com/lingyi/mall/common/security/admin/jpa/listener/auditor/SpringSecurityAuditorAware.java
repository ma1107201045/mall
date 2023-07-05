package com.lingyi.mall.common.security.admin.jpa.listener.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import com.lingyi.mall.common.security.admin.util.AdminAuthenticatorUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 3:05
 * @description
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {


    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        String userName = AdminAuthenticatorUtil.getUserName();
        return StrUtil.isBlank(userName) ? Optional.of(SecurityAdminConstant.UNKNOWN) : Optional.of(userName);
    }
}
