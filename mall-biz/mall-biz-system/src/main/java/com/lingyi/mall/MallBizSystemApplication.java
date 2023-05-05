package com.lingyi.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 15:49
 * @description 系统管理服务
 */
@EnableFeignClients
@MapperScan("com.lingyi.mall.biz.system.mapper")
@SpringBootApplication
public class MallBizSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallBizSystemApplication.class, args);
    }
}
