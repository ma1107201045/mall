package com.lingyi.mall.common.redis.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:07
 * @description
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit) != null;
    }

    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key);
        return expire == null ? 0L : expire;
    }

    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void set(String key, T value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public <T> T get(String key, Class<T> clazz) {
        Object obj = redisTemplate.opsForValue().get(key);
        return (T) obj;
    }

    public <T> boolean leftPush(String key, T value) {
        try {
            Long result = redisTemplate.opsForList().leftPush(key, value);
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("redis left push error. ", e);
            return false;
        }
    }


    @SafeVarargs
    public final <T> boolean leftPushAll(String key, T... values) {
        try {
            Long result = redisTemplate.opsForList().leftPush(key, values);
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("redis left push error. ", e);
            return false;
        }
    }

    public <T> boolean leftPushAll(String key, Collection<T> values) {
        try {
            Long result = redisTemplate.opsForList().leftPush(key, values);
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("redis left push  error. ", e);
            return false;
        }
    }

}
