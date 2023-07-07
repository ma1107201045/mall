package com.lingyi.mall.common.base.jpa.listener.auditor;

import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/7 8:57
 * @description
 */
public interface CustomAuditorAware<T> {

    Optional<T> getCurrentAuditor();
}
