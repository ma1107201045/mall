package com.lingyi.mall.common.redis.aspect;

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
    String keySuffix() default "";


    /**
     * 是否自动续期
     *
     * @return 结果
     */
    boolean isRenewal() default true;

    /**
     * 过期秒数,默认为5秒
     *
     * @return 轮询锁的时间
     */
    int expire() default 5;

    /**
     * 超时时间单位
     *
     * @return 秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
