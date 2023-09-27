package com.lingyi.mall.security.admin.constant;

import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 0:39
 * @Description:
 */
public class SecurityConstant {
    public static final RequestMatcher[] IGNORE_REQUEST_MATCHER_ARRAY = new RequestMatcher[]{
            new AntPathRequestMatcher("/swagger-ui/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/doc.html", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/favicon.ico", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/webjars/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/v3/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/get-base64-image-captcha", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/get-bin-image-captcha", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/users/permissions", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/logs", HttpMethod.POST.name())};
    public static final String LOGIN_PROCESSING_URL = "/login";
    public static final String LOGOUT_URL = "/logout";
    public static final String USER_NAME_PARAMETER = "userName";
    public static final String PASSWORD_PARAMETER = "password";
    public static final String IMAGE_CAPTCHA_PARAMETER = "imageCaptcha";
    public static final String IS_REMEMBER_ME_PARAMETER = "isRememberMe";
    public static final String REMEMBER_ME_COOKIE_NAME = "REMEMBER_ME";
    public static final String REMEMBER_ME_KEY = "199726ma.";
    public static final String COOKIE = "cookie";
    public static final String PERMISSION_SPLIT_CHAR = ",";
    public static final String SESSION_ATTRIBUTE_NAME = "imageCaptcha";
    public static final String UNKNOWN = "unknown";


    private SecurityConstant() {

    }
}
