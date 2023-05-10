package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 15:49
 * @description 系统管理服务
 */
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class MbsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MbsApplication.class, args);
    }
}
