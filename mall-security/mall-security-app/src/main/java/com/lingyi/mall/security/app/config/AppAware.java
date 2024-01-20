package com.lingyi.mall.security.app.config;

import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.security.core.bean.Authenticator;
import com.lingyi.mall.security.core.util.Aware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 3:05
 * @description
 */
@Component
public class AppAware implements Aware<Authenticator> {


    @Override
    @NonNull
    public Authenticator get() {
        String authenticator = StpUtil.getTokenValue();
        return new Authenticator();
    }
}
