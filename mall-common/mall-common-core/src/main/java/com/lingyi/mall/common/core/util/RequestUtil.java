package com.lingyi.mall.common.core.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;

/**
 * @author mwy
 * @datetime 2022/10/23 16:03
 * @description
 */
public final class RequestUtil {
    private static final String DELIMITER = ",";
    private static final String UNKNOWN = "unknown";
    private static final int LENGTH = 15;


    /**
     * 查找当前请求参数的ip地址
     *
     * @param request request请求对象
     * @return 当前请求的ip
     */
    public static String getRemoteHost(HttpServletRequest request) {
        var ip = request.getHeader("X-Forwarded-For");
        if (isNotRealIp(ip)) {
            if (isNotRealIp(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (isNotRealIp(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (isNotRealIp(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (isNotRealIp(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (isNotRealIp(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > LENGTH) {
            String[] ips = ip.split(DELIMITER);
            ip = Arrays.stream(ips)
                    .filter(strIp -> !(UNKNOWN.equalsIgnoreCase(strIp)))
                    .findFirst()
                    .orElse(ip);
        }
        return ip;
    }

    private static boolean isNotRealIp(String ip) {
        return ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip);
    }
}
