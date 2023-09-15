package com.lingyi.mall.security.admin.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.orm.jpa.listener.auditor.CustomAuditorAware;
import com.lingyi.mall.security.admin.constant.SecurityConstant;
import com.lingyi.mall.security.admin.util.AuthenticatorUtil;
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
public class SpringSecurityAuditorAware implements CustomAuditorAware<String> {


    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        var userName = AuthenticatorUtil.getUserName();
        return StrUtil.isBlank(userName) ? Optional.of(SecurityConstant.UNKNOWN) : Optional.of(userName);
    }
}
