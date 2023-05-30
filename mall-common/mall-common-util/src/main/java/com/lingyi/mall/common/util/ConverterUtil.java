package com.lingyi.mall.common.util;

import cn.hutool.core.bean.BeanUtil;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/30 15:19
 * @description
 */
public class ConverterUtil {


    public static <S, T> T to(S s, Class<T> tClass, String... ignoreProperties) {
        return BeanUtil.copyProperties(s, tClass, ignoreProperties);
    }

    public static <S, T> List<T> toList(List<S> listS, Class<T> tClass, String... ignoreProperties) {
        return listS.stream().map(s -> to(s, tClass, ignoreProperties)).toList();
    }
}
