package com.lingyi.mall.common.base.jpa.listener.auditor;

import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.entity.UserDetailsEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Object principal = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal).orElse(null);
        return Optional.of(principal instanceof UserDetailsEntity userDetailsEntity ?
                userDetailsEntity.getUsername() :
                BaseConstant.UNKNOWN);
    }
}
