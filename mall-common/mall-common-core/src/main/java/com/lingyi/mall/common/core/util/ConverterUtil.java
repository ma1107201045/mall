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
public final class ConverterUtil {


    private ConverterUtil() {
    }

    public static <S, T> void to(S source, T target) {
        BeanUtil.copyProperties(source, target, CopyOptions.create().setIgnoreNullValue(true));
    }

    public static <S, T> T to(S source, Class<T> clazz) {
        return BeanUtil.copyProperties(source, clazz);
    }

    public static <S, T> void toList(List<S> sourceList, List<T> targetList) {
        for (int i = 0; i < sourceList.size(); i++) {
            to(sourceList.get(i), targetList.get(i));
        }
    }

    public static <S, T> List<T> toList(List<S> sourceList, Class<T> clazz) {
        return BeanUtil.copyToList(sourceList, clazz, CopyOptions.create().setIgnoreNullValue(true));
    }

}
