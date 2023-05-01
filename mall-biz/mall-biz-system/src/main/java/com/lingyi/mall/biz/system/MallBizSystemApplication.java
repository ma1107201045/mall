package com.lingyi.mall.biz.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/28 15:05
 * @description 订单服务
 */
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallBizSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallBizSystemApplication.class, args);
    }
}
