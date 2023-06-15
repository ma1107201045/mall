package com.lingyi.mall.common.security.admin.filter;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.common.security.admin.constant.SecurityAdminConstant;
import com.lingyi.mall.common.security.admin.propertis.ImageCaptchaProperties;
import com.lingyi.mall.common.security.admin.util.ImageCaptchaUtil;
import com.lingyi.mall.common.util.ServerResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (this.isNeedAuthentication(request)) {
            try {
                ImageCaptchaProperties property = SpringUtil.getBean(ImageCaptchaProperties.class);
                String imageCaptcha1 = request.getParameter(SecurityAdminConstant.IMAGE_CAPTCHA_PARAMETER);
                Object imageCaptcha2 = request.getSession().getAttribute(property.getSessionAttributeName());
                if (Objects.isNull(imageCaptcha1) || Objects.isNull(imageCaptcha2)) {
                    throw new AuthenticationServiceException("验证码不能为空");
                }

                if (property.getCodeGenerator() == ImageCaptchaProperties.CodeGenerator.RANDOM) {
                    if (!imageCaptcha1.equals(imageCaptcha2)) {
                        throw new AuthenticationServiceException("验证码不正确");
                    }
                } else {
                    if (!imageCaptcha1.equals(ImageCaptchaUtil.calculate(imageCaptcha2))) {
                        throw new AuthenticationServiceException("验证码不正确");
                    }
                }
            } catch (Exception exception) {
                log.error("认证验证码失败，错误原因:", exception);
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setContentType(MediaType.APPLICATION_JSON.toString());
                response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(ServerResponse.fail(exception.getLocalizedMessage())));
                writer.flush();
                return;
            }
        }
        filterChain.doFilter(request, response);
    }


    private boolean isNeedAuthentication(HttpServletRequest request) {
        return LOGIN_ANT_PATH_REQUEST_MATCHER.matches(request);
    }

}
