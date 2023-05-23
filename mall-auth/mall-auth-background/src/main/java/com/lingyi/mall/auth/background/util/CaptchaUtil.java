package com.lingyi.mall.auth.background.util;

import cn.hutool.captcha.ICaptcha;
import com.lingyi.mall.auth.background.properties.MabCaptchaProperties;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/20 8:55
 * @description
 */
public class CaptchaUtil {


    /**
     * @param properties 验证码配置信息
     * @return 验证码实例
     */
    public static ICaptcha get(MabCaptchaProperties properties) {
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

}
