package com.lingyi.mall.auth.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:10
 * @description
 */
@SpringBootTest
public class MallAuthBackgroundApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void test01() {
        stringRedisTemplate.opsForValue().set("TEST", "马龙非");
    }
}
