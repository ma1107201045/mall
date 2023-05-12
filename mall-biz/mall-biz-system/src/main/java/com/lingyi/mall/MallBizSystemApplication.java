package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 15:49
 * @description 系统管理服务
 */
@EnableFeignClients
@EnableJpaAuditing
@EnableMethodSecurity
@SpringBootApplication
public class MallBizSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallBizSystemApplication.class, args);
    }
}
