package com.lingyi.mall.security.app.config;

import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.security.core.util.Authenticator;
import com.lingyi.mall.security.core.util.SecurityAware;
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
public class AppSecurityAware implements SecurityAware<Authenticator> {


    @Override
    @NonNull
    public Authenticator get() {
        String authenticator = StpUtil.getTokenValue();
        return new Authenticator();
    }
}
