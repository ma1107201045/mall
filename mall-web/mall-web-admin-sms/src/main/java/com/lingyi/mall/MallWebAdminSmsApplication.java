package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/23 0:23
 * @Description:
 */
@EnableMethodSecurity
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebAdminSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminSmsApplication.class, args);

    }
}
