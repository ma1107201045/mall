package com.lingyi.mall.common.base.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/30 15:19
 * @description
 */
public class ConverterUtil {

    public static <S, T> T to(S s, T t) {
        BeanUtil.copyProperties(s, t, CopyOptions.create().setIgnoreNullValue(true));
        return t;
    }

    public static <S, T> T to(S s, Class<T> tClass) {
        return BeanUtil.copyProperties(s, tClass);
    }

}
