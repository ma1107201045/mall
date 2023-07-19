package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.api.sms.dto.CaptchaReqDTO;
import com.lingyi.mall.common.base.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:23
 * @description
 */
@Component
public final class RedisKeyUtil {
    private static final String CAPTCHA_EXPIRY_DATA_KEY_FORMAT = "%s:captcha-expire-date:%s:%s:%s";
    private static final String CAPTCHA_INTERVAL_DATA_KEY_FORMAT = "%s:captcha-interval-date:%s:%s:%s";
    private static final String CAPTCHA_UPPER_LIMIT_KEY_FORMAT = "%s:captcha-upper-limit:%s:%s:%s";

    @Value("${spring.application.name}")
    private String applicationName;


    public String getCaptchaExpiryDateKey(CaptchaReqDTO captchaReqDTO) {
        return String.format(CAPTCHA_EXPIRY_DATA_KEY_FORMAT, applicationName,
                captchaReqDTO.getServiceType(), captchaReqDTO.getBusinessType(), captchaReqDTO.getPhoneNumber());
    }

    public String getCaptchaIntervalDateKey(CaptchaReqDTO captchaReqDTO) {
        return String.format(CAPTCHA_INTERVAL_DATA_KEY_FORMAT, applicationName,
                captchaReqDTO.getServiceType(), captchaReqDTO.getBusinessType(), captchaReqDTO.getPhoneNumber());
    }

    public String getCaptchaUpperLimitKey(CaptchaReqDTO captchaReqDTO) {
        return String.format(CAPTCHA_UPPER_LIMIT_KEY_FORMAT, applicationName,
                captchaReqDTO.getServiceType(), captchaReqDTO.getBusinessType(), captchaReqDTO.getPhoneNumber());
    }
}
