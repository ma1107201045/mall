package com.lingyi.mall.security.core.constant;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 0:39
 * @Description:
 */
public class NoAuthUrlConstant {
    public static final String[] IGNORE_URL_ARRAY = new String[]{
            "/swagger-ui/**",
            "/doc.html",
            "/favicon.ico",
            "/webjars/**",
            "/v3/**"};

    private NoAuthUrlConstant() {

    }
}
