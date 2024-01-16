package com.lingyi.mall.security.app.auditor;

import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.common.orm.util.Authenticator;
import com.lingyi.mall.common.orm.util.CustomAuditorAware;
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
public class AppAuditorAware implements CustomAuditorAware<Authenticator> {


    @Override
    @NonNull
    public Optional<Authenticator> getCurrentAuditor() {
        String authenticator = StpUtil.getTokenValue();
        return Optional.of(new Authenticator());
    }
}
