package com.lingyi.mall.auth.background;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
