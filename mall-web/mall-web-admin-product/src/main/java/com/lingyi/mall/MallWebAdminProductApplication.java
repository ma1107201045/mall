package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/6 22:08
 * @Description:
 */
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class MallWebAdminProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminProductApplication.class, args);
    }
}
