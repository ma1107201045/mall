package com.lingyi.mall.common.cache.aspect;

import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.util.SpelUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
    private static final String KEY_FORMAT = "%s:%s:%s";
    private static final String KEY_PREFIX = "redisson-lock";

    private final RedissonClient redissonClient;

    @Value("${spring.application.name}")
    private String applicationName;

//    @Pointcut("@annotation(com.lingyi.mall.common.cache.aspect.RedisLock)")
//    private void redisLockPointcut() {
//    }

    @Around("@annotation(redisLock)")
    public Object around(ProceedingJoinPoint joinPoint, RedisLock redisLock) throws Throwable {
        String keySuffix = SpelUtil.parse(joinPoint.getTarget(), redisLock.keySuffix(), getMethod(joinPoint), joinPoint.getArgs());
        RLock rLock = redissonClient.getLock(String.format(KEY_FORMAT, applicationName, KEY_PREFIX, keySuffix));
        if (redisLock.isRenewal()) {
            rLock.lock();
        } else {
            rLock.lock(redisLock.expire(), redisLock.timeUnit());
        }
        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            rLock.unlock();
        }
        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }
}
