package com.lingyi.mall.security.app.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/8/6 19:53
 * @Description:
 */
@Component
public class RedisKeyUtil {

    private static final String TOKEN_BLACKLIST_KEY_FORMAT = "%s:token-blacklist:%s";


    @Value("${spring.application.name}")
    private String applicationName;

    public String getTokenBlacklistKey(String token) {
        return String.format(TOKEN_BLACKLIST_KEY_FORMAT, applicationName, token);
    }
}