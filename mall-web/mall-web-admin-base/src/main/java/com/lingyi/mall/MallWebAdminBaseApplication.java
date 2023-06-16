package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 10:15
 * @description
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableMethodSecurity
@SpringBootApplication
public class MallWebAdminBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminBaseApplication.class, args);
    }
}
