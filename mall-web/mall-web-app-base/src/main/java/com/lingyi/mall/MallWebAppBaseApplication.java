package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 8:51
 * @description
 */
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class MallWebAppBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAppBaseApplication.class, args);
    }
}
