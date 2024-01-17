package com.lingyi.mall.web.admin.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/6 22:08
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lingyi.mall")
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallWebAdminProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminProductApplication.class, args);
    }
}
