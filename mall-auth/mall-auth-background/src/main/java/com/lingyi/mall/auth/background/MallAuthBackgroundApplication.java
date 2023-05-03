package com.lingyi.mall.auth.background;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:10
 * @description
 */
@SpringBootApplication(scanBasePackages = "com.lingyi.mall")
public class MallAuthBackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthBackgroundApplication.class, args);
    }
}
