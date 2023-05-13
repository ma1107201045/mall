package com.lingyi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 20:17
 * @Description: 基础服务
 */
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class MallBizBaseBApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallBizBaseBApplication.class, args);
    }
}
