package com.lingyi.mall.common.orm.util;

import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/7 8:57
 * @description
 */
public interface CustomAuditorAware<T extends Authenticator> {

    /**
     * getCurrentAuditor
     *
     * @return Optional
     */
    Optional<T> getCurrentAuditor();
}
