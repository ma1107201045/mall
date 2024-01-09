package com.lingyi.mall.auth.admin.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.MathGenerator;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.auth.admin.model.dto.AuthAdminDTO;
import com.lingyi.mall.auth.admin.model.vo.AuthAdminVO;
import com.lingyi.mall.auth.admin.properties.ImageCaptchaProperties;
import com.lingyi.mall.auth.admin.properties.enums.CodeGeneratorType;
import com.lingyi.mall.auth.admin.service.AuthAdminService;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ServerResponse;
import com.lingyi.mall.security.admin.constant.SecurityConstant;
import com.lingyi.mall.security.admin.enums.FailEnum;
import com.lingyi.mall.security.admin.util.CodeGeneratorProxy;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class AuthAdminServiceImpl implements AuthAdminService {

    private final ImageCaptchaProperties properties;


    private final UserFeignConsumer userFeignConsumer;

    @Override
    public AuthAdminVO login(AuthAdminDTO authAdminDTO) {
        //查询用户信息和菜单权限
        var userResponse = userFeignConsumer.getUserByUserName(authAdminDTO.getUserName());
        return ConverterUtil.to(userResponse, AuthAdminVO.class);
    }

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
        if (properties.getCodeGeneratorType() == CodeGeneratorType.MATH) {
            abstractCaptcha.setGenerator(new CodeGeneratorProxy(new MathGenerator(1)));
        }
        return abstractCaptcha;
    }
}
