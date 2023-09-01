package com.lingyi.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/1 15:07
 * @Description: 网关服务
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallGatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
    }
}
