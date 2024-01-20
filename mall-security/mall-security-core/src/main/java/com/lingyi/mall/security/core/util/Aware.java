package com.lingyi.mall.security.core.util;

import com.lingyi.mall.security.core.bean.Authenticator;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/16 14:23
 * @Description:
 */
public interface Aware<T extends Authenticator> {


    T get();
}
