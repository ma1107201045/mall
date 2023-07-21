package com.lingyi.mall.common.security.app.constant;

import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 0:39
 * @Description:
 */
public class SecurityConstant {
    public static final List<RequestMatcher> REQUEST_MATCHER_LIST = Arrays.asList(
            new AntPathRequestMatcher("/swagger-ui/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/doc.html", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/webjars/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/v3/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.HEAD.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.PUT.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.PATCH.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.DELETE.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.OPTIONS.name()),
            new AntPathRequestMatcher("/auth/app/**", HttpMethod.TRACE.name()),
            new AntPathRequestMatcher("/app/sms/captchas/send", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/app/sms/captchas/verify", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/app/member/members", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/app/member/members", HttpMethod.POST.name()),
            new AntPathRequestMatcher("/admin/system/logs", HttpMethod.POST.name()));
    public static final String IS_IGNORE_REQUEST_ATTRIBUTE = "isIgnoreRequest";
    public static final String JWT_KEY = "199726ma.";
    public static final int TOKEN_EXPIRATION_TIME_VALUE = 30;
    public static final ChronoUnit CHRONO_UNIT = ChronoUnit.SECONDS;
    public static final String AUTHORIZATION = "Authorization";
    public static final String UNKNOWN = "unknown";

    private SecurityConstant() {

    }
}
