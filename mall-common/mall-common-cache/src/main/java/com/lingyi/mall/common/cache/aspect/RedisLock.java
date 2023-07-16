package com.lingyi.mall.common.cache.aspect;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/15 10:02
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {


    /**
     * redis锁 key后缀 支持SPEL表达式
     */
    @AliasFor("keySuffix")
    String value() default "";

    /**
     * redis锁 key后缀 支持SPEL表达式
     */
    @AliasFor("value")
    String keySuffix() default "";

    /**
     * 过期秒数,默认为30秒
     *
     * @return 轮询锁的时间
     */
    int expire() default 30;

    /**
     * 超时时间单位
     *
     * @return 秒
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;
}
