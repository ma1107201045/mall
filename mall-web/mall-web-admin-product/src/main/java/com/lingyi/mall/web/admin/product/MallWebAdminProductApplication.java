package com.lingyi.mall.web.admin.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/6 22:08
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lingyi.mall")
@EntityScan(basePackages = "com.lingyi.mall.biz.*.model.entity")
@EnableJpaRepositories(basePackages = "com.lingyi.mall.biz.*.dao.repository")
@MapperScan(basePackages = "com.lingyi.mall.biz.*.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallWebAdminProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebAdminProductApplication.class, args);
    }
}
