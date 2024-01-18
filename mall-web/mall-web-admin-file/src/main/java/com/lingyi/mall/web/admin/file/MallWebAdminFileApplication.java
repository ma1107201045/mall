package com.lingyi.mall.web.admin.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 21:08
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lingyi.mall")
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallWebAdminFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminFileApplication.class, args);
    }
}
