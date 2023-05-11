package com.lingyi.mall.common.fill.jpa.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.bean.constant.BaseConstant;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 3:05
 * @description
 */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        String username = StrUtil.EMPTY;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                username = user.getUsername();
            }
        } else {
            username = BaseConstant.UNKNOWN;
        }
        return Optional.of(username);
    }
}
