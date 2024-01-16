package com.lingyi.mall.security.admin.auditor;

import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.common.orm.util.Authenticator;
import com.lingyi.mall.common.orm.util.CustomAuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 3:05
 * @description
 */
@Component
public class AdminAuditorAware implements CustomAuditorAware<Authenticator> {


    @Override
    @NonNull
    public Optional<Authenticator> getCurrentAuditor() {
        Authenticator authenticator = (Authenticator) StpUtil.getSession().get(StpUtil.TYPE);
        return Objects.isNull(authenticator) ? Optional.of(new Authenticator()) : Optional.of(authenticator);
    }
}
