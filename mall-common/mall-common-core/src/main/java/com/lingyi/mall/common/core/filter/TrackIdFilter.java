package com.lingyi.mall.common.core.filter;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Locale;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/6 16:39
 * @description
 */
public class TrackIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        var requestId = request.getHeader(BaseConstant.TRACK_ID_NAME);
        MDC.put(BaseConstant.TRACK_ID_NAME, StrUtil.isBlank(requestId) ? IdUtil.fastSimpleUUID().toUpperCase(Locale.ROOT) : BaseConstant.TRACK_ID_PREFIX + requestId);
        filterChain.doFilter(request, response);
        MDC.remove(BaseConstant.TRACK_ID_NAME);
    }
}
