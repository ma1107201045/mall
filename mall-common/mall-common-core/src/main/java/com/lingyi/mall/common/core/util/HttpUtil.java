package com.lingyi.mall.common.core.util;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.lingyi.mall.common.core.constant.BaseConstant;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/9 11:15
 * @description
 */
public final class HttpUtil {

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
    public static void setHeader(String name, String value) {
        if (Objects.nonNull(getResponse())) {
            getResponse().addHeader(name, value);
        }
    }

    public static Cookie[] getCookies() {
        return Objects.isNull(getRequest()) ? ObjectUtil.getNull() : getRequest().getCookies();
    }

    public static void setCookies(Cookie[] cookies) {
        var response = getResponse();
        if (Objects.nonNull(response)) {
            Arrays.asList(cookies).forEach(response::addCookie);
        }
    }

    public static void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) {
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.computeIfAbsent(path, k -> new ArrayList<>());
            values.add(jsonNode.asText());
            return;
        }
        // 数组节点
        if (jsonNode.isArray()) {
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StrUtil.isNotBlank(path)) {
                    buildQuery(entry.getValue(), path + BaseConstant.POINT_CHAR + entry.getKey(), queries);
                } else {  // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
