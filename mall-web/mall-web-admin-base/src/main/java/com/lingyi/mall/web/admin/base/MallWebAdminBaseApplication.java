package com.lingyi.mall.web.admin.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 10:15
 * @description
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lingyi.mall.api.*.feign")
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallWebAdminBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminBaseApplication.class, args);
    }
}
