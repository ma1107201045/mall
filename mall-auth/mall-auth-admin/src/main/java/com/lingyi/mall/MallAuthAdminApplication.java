package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:10
 * @description
 */
@EnableFeignClients
@ConfigurationPropertiesScan
@SpringBootApplication
public class MallAuthAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthAdminApplication.class, args);
    }
}
