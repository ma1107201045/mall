package com.lingyi.mall.common.base.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.enums.BaseFailEnum;
import com.lingyi.mall.common.base.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Slf4j
public final class AssertUtil {

    private AssertUtil() {

    }

    public static void isNull(Object object, BaseFailEnum failEnum) {
        isTrue(ObjUtil.isNull(object), failEnum);
    }

    public static void notNull(Object object, BaseFailEnum failEnum) {
        isTrue(ObjUtil.isNotNull(object), failEnum);
    }

    public static void notNull(Object object, RuntimeException exception) {
        isTrue(ObjUtil.isNotNull(object), exception);
    }

    public static void isTrue(boolean flag, BaseFailEnum baseFailEnum) {
        if (!flag) {
            Object[] objects = getFailEnumValues(baseFailEnum);
            throw new BizException((Integer) objects[0], (String) objects[1]);
        }
    }

    public static void isTrue(boolean flag, RuntimeException exception) {
        if (!flag) {
            throw exception;
        }
    }

    public static void isFalse(boolean flag, BaseFailEnum failEnum) {
        isTrue(!flag, failEnum);
    }

    public static void isGtZero(int number, BaseFailEnum failEnum) {
        isTrue(number > 0, failEnum);
    }

    public static void isLtZero(int number, BaseFailEnum failEnum) {
        isFalse(number < 0, failEnum);
    }

    public static <T extends CharSequence> T isEmpty(T t, BaseFailEnum failEnum) {
        isTrue(StrUtil.isEmpty(t), failEnum);
        return t;
    }

    public static <T extends CharSequence> T notEmpty(T t, BaseFailEnum failEnum) {
        isTrue(StrUtil.isNotEmpty(t), failEnum);
        return t;
    }

    public static <T extends CharSequence> T isBlack(T t, BaseFailEnum failEnum) {
        isTrue(StrUtil.isBlank(t), failEnum);
        return t;
    }

    public static <T extends CharSequence> T notBlack(T t, BaseFailEnum failEnum) {
        isTrue(StrUtil.isNotBlank(t), failEnum);
        return t;
    }

    public static <T extends CharSequence> T notBlack(T t, RuntimeException exception) {
        isTrue(StrUtil.isNotBlank(t), exception);
        return t;
    }

    public static <T> T[] isEmpty(T[] t, BaseFailEnum failEnum) {
        isTrue(ArrayUtil.isEmpty(t), failEnum);
        return t;
    }

    public static <T> T[] notEmpty(T[] t, BaseFailEnum failEnum) {
        isTrue(ArrayUtil.isNotEmpty(t), failEnum);
        return t;
    }

    public static <E, T extends Iterable<E>> T isEmpty(T t, BaseFailEnum failEnum) {
        isTrue(CollUtil.isEmpty(t), failEnum);
        return t;
    }

    public static <E, T extends Iterable<E>> T notEmpty(T t, BaseFailEnum failEnum) {
        isTrue(CollUtil.isNotEmpty(t), failEnum);
        return t;
    }

    public static Object[] getFailEnumValues(BaseFailEnum failEnum) {
        Object[] objects = new Object[2];
        try {
            Class<?> clazz = failEnum.getClass();
            Object code = clazz.getMethod(BaseConstant.CODE_GET_METHOD_NAME).invoke(failEnum);
            Object message = clazz.getMethod(BaseConstant.MESSAGE_GET_METHOD_NAME).invoke(failEnum);
            if (code instanceof Integer && message instanceof String) {
                objects[0] = code;
                objects[1] = message;
            }
        } catch (Exception e) {
            log.error("未知异常", e);
            objects[0] = HttpStatus.INTERNAL_SERVER_ERROR.value();
            objects[1] = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
        return objects;
    }


}
