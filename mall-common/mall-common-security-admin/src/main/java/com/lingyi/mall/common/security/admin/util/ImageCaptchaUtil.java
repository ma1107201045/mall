package com.lingyi.mall.common.security.admin.util;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import com.lingyi.mall.common.security.admin.propertis.ImageCaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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
public class ImageCaptchaUtil {


    /**
     * @param properties 验证码配置信息
     * @return 验证码实例
     */
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
            default -> log.error("获取验证码结果出错");
        }
        if (properties.getCodeGenerator() == ImageCaptchaProperties.CodeGenerator.MATH) {
            abstractCaptcha.setGenerator(new MathGenerator(1));
        }
        return abstractCaptcha;

    }

    /**
     * 计算图形验证码中的数字运算结果
     *
     * @param captcha 验证码
     * @return 结果字符串
     */
    public static String calculate(Object captcha) {
        try {
            String captchaStr = (String) captcha;
            char firstOperandChar = captchaStr.charAt(0);
            char operatorChar = captchaStr.charAt(1);
            char secondOperandChar = captchaStr.charAt(2);
            int firstOperand = Integer.parseInt(String.valueOf(firstOperandChar));
            int secondOperand = Integer.parseInt(String.valueOf(secondOperandChar));
            int result = 0;
            switch (operatorChar) {
                case '+' -> result = firstOperand + secondOperand;
                case '-' -> result = firstOperand - secondOperand;
                case '*' -> result = firstOperand * secondOperand;
                default -> log.error("计算验证码结果出错");
            }
            return String.valueOf(result);
        } catch (Exception e) {
            log.error("计算验证码出错");
            return null;
        }
    }

}
