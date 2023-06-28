package com.lingyi.mall.common.security.admin.util;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import com.lingyi.mall.common.security.admin.propertis.ImageCaptchaProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/20 8:55
 * @description
 */
@Slf4j
public class ImageCaptchaUtil {
    public static final String SESSION_ATTRIBUTE_NAME = "imageCaptcha";

    public static ICaptcha get(ImageCaptchaProperties properties) {
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
        if (properties.getCodeGenerator() == ImageCaptchaProperties.CodeGenerator.MATH) {
            abstractCaptcha.setGenerator(new CodeGeneratorProxy(new MathGenerator(1)));
        }
        return abstractCaptcha;
    }


}
