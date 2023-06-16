package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:24
 * @description
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallAuthAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthAppApplication.class, args);
    }
}
