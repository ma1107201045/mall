package com.lingyi.mall.auth.admin.util;

import cn.hutool.captcha.ICaptcha;
import com.lingyi.mall.auth.admin.properties.CaptchaProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/20 8:55
 * @description
 */
@Slf4j
public class CaptchaUtil {


    /**
     * @param properties 验证码配置信息
     * @return 验证码实例
     */
    public static ICaptcha get(CaptchaProperties properties) {
        return switch (properties.getType()) {
            case LINE ->
                    cn.hutool.captcha.CaptchaUtil.createLineCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case CIRCLE ->
                    cn.hutool.captcha.CaptchaUtil.createCircleCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case SHEAR ->
                    cn.hutool.captcha.CaptchaUtil.createShearCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case GIF ->
                    cn.hutool.captcha.CaptchaUtil.createGifCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount());
        };

    }


    public static void write(CaptchaProperties captchaProperties) {
        ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()));
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        HttpServletResponse response = Objects.requireNonNull(servletRequestAttributes.getResponse());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ICaptcha captcha = CaptchaUtil.get(captchaProperties);
        session.setAttribute(captchaProperties.getSessionAttributeName(), captcha.getCode());
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            captcha.write(os);
        } catch (IOException e) {
            log.error("验证码有误", e);
        } finally {
            if (Objects.nonNull(os)) {
                try {
                    os.close();
                    os.flush();
                } catch (IOException e) {
                    log.error("关闭流失败", e);
                }
            }
        }

    }

}
