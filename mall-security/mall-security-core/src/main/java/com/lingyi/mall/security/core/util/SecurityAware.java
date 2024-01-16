package com.lingyi.mall.security.core.util;

import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 14:23
 * @Description:
 */
public interface SecurityAware<T extends Authenticator> {


    T get();
}
