package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.PayloadUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/3 14:48
 * @description
 */
@Slf4j
public class JwtTokenRenewalFilter extends GenericFilterBean {

    @Autowired
    private MemberFeignConsumer memberFeignConsumer;
    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        this.doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String oldToken = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(oldToken)) {
            JWT jwt = JWTUtil.parseToken(oldToken);
            JWTPayload payload = jwt.getPayload();
            Date expiresAt = (Date) payload.getClaim(JWTPayload.EXPIRES_AT);
            if (expiresAt.equals(DateUtil.date()) || expiresAt.after(DateUtil.date())) {
                String phoneNumber = (String) payload.getClaim(SecurityConstant.PHONE_NUMBER);
                MemberRespDTO memberRespDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
                String token = JWTUtil.createToken(PayloadUtil.generate(memberRespDTO), SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));
                response.setHeader(SecurityConstant.AUTHORIZATION, token);
            }
        }
        chain.doFilter(request, response);
    }

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }

    public void setMemberFeignConsumer(MemberFeignConsumer memberFeignConsumer) {
        this.memberFeignConsumer = memberFeignConsumer;
    }
}
