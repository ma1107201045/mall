package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/6 22:04
 * @Description:
 */
@EnableMethodSecurity
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebAdminMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminMemberApplication.class, args);
    }
}
