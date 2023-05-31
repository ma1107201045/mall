package com.lingyi.mall.common.security.app.authentication.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.common.security.app.SecurityConfig;
import com.lingyi.mall.common.security.app.authentication.entity.MemberDetailsEntity;
import com.lingyi.mall.common.security.app.authentication.token.PhoneNumberVerificationCodeToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/31 9:03
 * @description
 */
public class JwtAuthorizationFilter extends GenericFilterBean {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    private final GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorization = request.getHeader(AUTHORIZATION_HEADER);
        if (StrUtil.isBlank(authorization)) {
            throw new InsufficientAuthenticationException(this.messages.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"));
        }
        boolean result = JWTUtil.verify(authorization, SecurityConfig.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        if (!result) {
            throw new InsufficientAuthenticationException(this.messages.getMessage("ExceptionTranslationFilter.insufficientAuthentication", "Full authentication is required to access this resource"));
        }
        JWT jwt = JWTUtil.parseToken(authorization);
        JSONObject payloads = jwt.getPayloads();
        MemberDetailsEntity memberDetailsEntity = payloads.toBean(MemberDetailsEntity.class);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        PhoneNumberVerificationCodeToken phoneNumberVerificationCodeToken = new PhoneNumberVerificationCodeToken(memberDetailsEntity.getPhoneNumber(), memberDetailsEntity.getVerificationCode(), this.authoritiesMapper.mapAuthorities(memberDetailsEntity.getAuthorities()));
        securityContext.setAuthentication(phoneNumberVerificationCodeToken);
        chain.doFilter(request, response);
    }
}
