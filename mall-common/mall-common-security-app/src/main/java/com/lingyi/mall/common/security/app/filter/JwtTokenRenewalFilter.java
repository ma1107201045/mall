package com.lingyi.mall.common.security.app.filter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.common.security.app.constant.SecurityConstant;
import com.lingyi.mall.common.security.app.util.PayloadUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/3 14:48
 * @description
 */
@Slf4j
public class JwtTokenRenewalFilter extends AbstractJwtTokenFilter {

    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
    private MemberFeignConsumer memberFeignConsumer;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String oldToken = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(oldToken)) {
            JWTPayload payload = JWTUtil.parseToken(oldToken).getPayload();
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
