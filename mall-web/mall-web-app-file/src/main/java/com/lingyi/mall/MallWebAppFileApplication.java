package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/7 17:27
 * @description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebAppFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAppFileApplication.class, args);
    }
}
