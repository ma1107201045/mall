package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.api.sms.dto.CaptchaReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
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
public class RedisKeyUtil {

    private static final String CAPTCHA_EXPIRY_DATA = "captcha-expire-date";
    private static final String CAPTCHA_INTERVAL_DATA = "captcha-interval-date";
    private static final String CAPTCHA_UPPER_LIMIT = "captcha-upper-limit";

    @Value("${spring.application.name}")
    private String keyPrefix;


    public String getCaptchaExpiryDateKey(CaptchaReqDTO captchaReqDTO) {
        return keyPrefix + BaseConstant.COLON_CHAR
                + CAPTCHA_EXPIRY_DATA + BaseConstant.COLON_CHAR
                + captchaReqDTO.getServiceType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getBusinessType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getPhoneNumber();
    }

    public String getCaptchaIntervalDateKey(CaptchaReqDTO captchaReqDTO) {
        return keyPrefix + BaseConstant.COLON_CHAR
                + CAPTCHA_INTERVAL_DATA + BaseConstant.COLON_CHAR
                + captchaReqDTO.getServiceType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getBusinessType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getPhoneNumber();
    }

    public String getCaptchaUpperLimitKey(CaptchaReqDTO captchaReqDTO) {
        return keyPrefix + BaseConstant.COLON_CHAR
                + CAPTCHA_UPPER_LIMIT + BaseConstant.COLON_CHAR
                + captchaReqDTO.getServiceType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getBusinessType() + BaseConstant.COLON_CHAR
                + captchaReqDTO.getPhoneNumber();
    }
}
