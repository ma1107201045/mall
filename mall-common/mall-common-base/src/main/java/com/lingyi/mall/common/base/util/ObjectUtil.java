package com.lingyi.mall.common.base.util;

import cn.hutool.core.util.ReflectUtil;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/21 13:28
 * @description
 */
public class ObjectUtil {


    public static <T> T getNull() {
        return null;
    }

    public static <T> T newInstance(Class<T> tClass) {
        return ReflectUtil.newInstance(tClass);
    }
}
