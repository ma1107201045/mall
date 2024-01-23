package com.lingyi.mall.web.admin.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/7/23 0:23
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lingyi.mall.api.*.feign")
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallWebAdminInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminInfoApplication.class, args);
    }
}
