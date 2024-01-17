package com.lingyi.mall.security.app.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.util.CustomAuditorAware;
import com.lingyi.mall.security.core.util.AuthenticatorUtil;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 14:34
 * @Description:
 */
@Component
public class AppAuditorAware implements CustomAuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        var currentUserName = AuthenticatorUtil.getCurrentUserName();
        return StrUtil.isBlank(currentUserName) ? Optional.empty() : Optional.of(currentUserName);
    }
}