package com.lingyi.mall.common.core.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/9 11:15
 * @description
 */
public class HttpUtil {

    private HttpUtil() {

    }

    private static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    public static String getHeader(String name) {
        return getRequest().getHeader(name);
    }

    public static void addHeader(String name, String value) {
        getResponse().addHeader(name, value);
    }

}
