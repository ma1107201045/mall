package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 8:51
 * @description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallWebAppBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAppBaseApplication.class, args);
    }
}
