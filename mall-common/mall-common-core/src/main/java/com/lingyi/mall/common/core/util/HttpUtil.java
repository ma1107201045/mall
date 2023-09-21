package com.lingyi.mall.common.core.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/9 11:15
 * @description
 */
public class HttpUtil {

    private HttpUtil() {

    }

    @Nullable
    private static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    @Nullable
    public static HttpServletRequest getRequest() {
        return Objects.isNull(getServletRequestAttributes()) ? ObjectUtil.getNull() : getServletRequestAttributes().getRequest();
    }

    @Nullable
    public static HttpServletResponse getResponse() {
        return Objects.isNull(getServletRequestAttributes()) ? ObjectUtil.getNull() : getServletRequestAttributes().getResponse();
    }

    @Nullable
    public static String getHeader(String name) {
        return Objects.isNull(getRequest()) ? ObjectUtil.getNull() : getRequest().getHeader(name);
    }

    @Nullable
    public static void addHeader(String name, String value) {
        if (Objects.nonNull(getResponse())) {
            getResponse().addHeader(name, value);
        }
    }

}
