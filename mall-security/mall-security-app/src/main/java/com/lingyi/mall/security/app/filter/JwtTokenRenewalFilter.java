package com.lingyi.mall.security.app.filter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.security.app.constant.SecurityConstant;
import com.lingyi.mall.security.app.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.io.IOException;

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
        var oldToken = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (StrUtil.isNotBlank(oldToken)) {
            var expiresAt = JwtUtil.getJwtPayloadExp(oldToken);
            if (!DateUtil.date().after(expiresAt)) {
                var phoneNumber = JwtUtil.getJwtPayloadPhoneNumber(oldToken);
                var memberRespDTO = memberFeignConsumer.getByPhoneNumber(phoneNumber);
                var token = JwtUtil.createToken(memberRespDTO);
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
