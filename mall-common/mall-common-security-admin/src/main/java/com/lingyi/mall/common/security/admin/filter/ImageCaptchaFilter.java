package com.lingyi.mall.common.security.admin.filter;

import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import com.lingyi.mall.common.security.admin.exception.ImageCaptchaException;
import com.lingyi.mall.common.security.admin.util.CommonWriteUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/11 19:55
 * @Description:
 */
@Slf4j
public class ImageCaptchaFilter extends OncePerRequestFilter {

    private static final AntPathRequestMatcher LOGIN_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher(SecurityAdminConstant.LOGIN_PROCESSING_URL, HttpMethod.POST.name());
    protected MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (this.isNeedAuthentication(request)) {
            try {
                String imageCaptcha = request.getParameter(SecurityAdminConstant.IMAGE_CAPTCHA_PARAMETER);
                ICaptcha iCaptcha = (ICaptcha) session.getAttribute(SecurityAdminConstant.SESSION_ATTRIBUTE_NAME);
                if (StrUtil.isBlank(imageCaptcha) || Objects.isNull(iCaptcha)) {
                    throw new ImageCaptchaException(this.message.getMessage("ImageCaptchaFilter.captchaNull", "ImageCaptcha is null"));
                }
                if (!iCaptcha.verify(imageCaptcha)) {
                    throw new ImageCaptchaException(this.message.getMessage("ImageCaptchaFilter.captchaError", "ImageCaptcha is error"));
                }
            } catch (AuthenticationException exception) {
                session.removeAttribute(SecurityAdminConstant.SESSION_ATTRIBUTE_NAME);
                CommonWriteUtil.write(response, exception);
                return;
            }
            session.removeAttribute(SecurityAdminConstant.SESSION_ATTRIBUTE_NAME);
        }
        filterChain.doFilter(request, response);
    }


    private boolean isNeedAuthentication(HttpServletRequest request) {
        return LOGIN_ANT_PATH_REQUEST_MATCHER.matches(request);
    }

    public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        this.message = messageSourceAccessor;
    }
}
