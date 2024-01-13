package com.lingyi.mall.security.admin.auditor;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.util.CustomAuditorAware;
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
        var userName ="";
        return StrUtil.isBlank(userName) ? Optional.of("") : Optional.of(userName);
    }
}
