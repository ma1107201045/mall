package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 10:03
 * @description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebAppMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAppMemberApplication.class, args);
    }
}
