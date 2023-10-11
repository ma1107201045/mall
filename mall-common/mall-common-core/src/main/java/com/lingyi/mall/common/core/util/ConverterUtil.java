package com.lingyi.mall.common.core.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/30 15:19
 * @description
 */
public class ConverterUtil {

    public static <S, T> void to(S source, T target) {
        BeanUtil.copyProperties(source, target, CopyOptions.create().setIgnoreNullValue(true));
    }

    public static <S, T> T to(S source, Class<T> clazz) {
        return BeanUtil.copyProperties(source, clazz);
    }

    public static <S, T> void toList(List<S> sourceList, Class<T> clazz) {
        BeanUtil.copyToList(sourceList, clazz, CopyOptions.create().setIgnoreNullValue(true));
    }

}
