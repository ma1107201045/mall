package com.lingyi.mall.auth.admin.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.MathGenerator;
import com.lingyi.mall.auth.admin.properties.ImageCaptchaProperties;
import com.lingyi.mall.auth.admin.service.AdminService;
import com.lingyi.mall.common.base.util.CodeGeneratorProxy;
import com.lingyi.mall.common.security.admin.constant.SecurityConstant;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/29 8:51
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ImageCaptchaProperties properties;

    @Override
    public String readImageCaptcha(HttpSession session) {
        AbstractCaptcha abstractCaptcha = getImageCaptchaObject();
        session.setAttribute(SecurityConstant.SESSION_ATTRIBUTE_NAME, abstractCaptcha);
        return abstractCaptcha.getImageBase64Data();
    }

    @Override
    public void writeImageCaptcha(HttpSession session, HttpServletResponse response) {
        AbstractCaptcha abstractCaptcha = getImageCaptchaObject();
        session.setAttribute(SecurityConstant.SESSION_ATTRIBUTE_NAME, abstractCaptcha);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        try (OutputStream os = response.getOutputStream()) {
            abstractCaptcha.write(os);
        } catch (IOException e) {
            log.error("write image captcha error");
        }
    }


    private AbstractCaptcha getImageCaptchaObject() {
        AbstractCaptcha abstractCaptcha = null;
        switch (properties.getDisturbanceType()) {
            case LINE ->
                    abstractCaptcha = CaptchaUtil.createLineCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case CIRCLE ->
                    abstractCaptcha = CaptchaUtil.createCircleCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case SHEAR ->
                    abstractCaptcha = CaptchaUtil.createShearCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount(), properties.getTypeCount());
            case GIF ->
                    abstractCaptcha = CaptchaUtil.createGifCaptcha(properties.getWidth(), properties.getHeight(), properties.getCount());
        }
        if (properties.getCodeGeneratorType() == ImageCaptchaProperties.CodeGeneratorType.MATH) {
            abstractCaptcha.setGenerator(new CodeGeneratorProxy(new MathGenerator(1)));
        }
        return abstractCaptcha;
    }
}
