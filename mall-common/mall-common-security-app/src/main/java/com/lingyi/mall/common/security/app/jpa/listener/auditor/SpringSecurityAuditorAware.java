package com.lingyi.mall.common.security.app.jpa.listener.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.base.jpa.listener.auditor.CustomAuditorAware;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.AuthenticatorUtil;
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
        String userName = AuthenticatorUtil.getUserName();
        return StrUtil.isBlank(userName) ? Optional.of(SecurityConstant.UNKNOWN) : Optional.of(userName);
    }
}
