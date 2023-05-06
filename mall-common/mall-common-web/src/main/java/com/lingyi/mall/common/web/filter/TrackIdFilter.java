package com.lingyi.mall.common.web.filter;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.constant.BaseConstant;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Locale;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/6 16:39
 * @description
 */
@Component
public class TrackIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String requestId = request.getHeader(BaseConstant.TRACK_ID);
        MDC.put(BaseConstant.TRACK_ID, StrUtil.isBlank(requestId) ? IdUtil.fastSimpleUUID().toUpperCase(Locale.ROOT) : BaseConstant.REQUEST_ID_PREFIX + requestId);
        filterChain.doFilter(request, response);
        MDC.remove(BaseConstant.TRACK_ID);
    }
}
