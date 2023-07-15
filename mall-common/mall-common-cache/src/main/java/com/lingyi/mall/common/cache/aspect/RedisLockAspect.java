package com.lingyi.mall.common.cache.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/15 10:02
 * @description
 */
@Aspect
@Component
@RequiredArgsConstructor
public class RedisLockAspect {

    private final RedissonClient redissonClient;
    private static final String REDISSON_LOCK_PREFIX = "redisson-lock:";

    @Pointcut("@annotation(com.lingyi.mall.common.cache.aspect.RedisLock)")
    private void redisLockPointcut() {
    }

    @Around("@annotation(redisLock)")
    public Object around(ProceedingJoinPoint joinPoint, RedisLock redisLock) throws Throwable {
        String name = redisLock.name();
        String key = redisLock.key();
        RLock rLock = redissonClient.getLock(REDISSON_LOCK_PREFIX + name + key);
        rLock.lock(redisLock.expire(), redisLock.timeUnit());
        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            rLock.unlock();
        }
        return result;
    }
}
