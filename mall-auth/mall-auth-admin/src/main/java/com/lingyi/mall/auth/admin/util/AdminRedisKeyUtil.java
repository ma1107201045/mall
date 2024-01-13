package com.lingyi.mall.auth.admin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:23
 * @description
 */
@Component
public final class AdminRedisKeyUtil {

    private static final String IMAGE_CAPTCHA_KEY_FORMAT = "%s:info-image-captcha:%s";

    @Value("${spring.application.name}")
    private String applicationName;

    public String getImageCaptchaKey(String uuid) {
        return String.format(applicationName + IMAGE_CAPTCHA_KEY_FORMAT, uuid);
    }


}
