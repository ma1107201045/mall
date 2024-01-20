package com.lingyi.mall.security.admin.config;

import cn.dev33.satoken.stp.StpUtil;
import com.lingyi.mall.security.core.bean.Authenticator;
import com.lingyi.mall.security.core.util.Aware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 3:05
 * @description
 */
@Component
public class AdminAware implements Aware<Authenticator> {


    @Override
    @NonNull
    public Authenticator get() {
        Authenticator authenticator = (Authenticator) StpUtil.getSession().get(StpUtil.TYPE);
        return Objects.isNull(authenticator) ? new Authenticator() : authenticator;
    }
}
