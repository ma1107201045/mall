package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.api.sms.dto.AbstractSmsReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.CaptchaVerifyReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:23
 * @description
 */
@Component
public final class SmsRedisKeyUtil {
    private static final String CAPTCHA_KEY_FORMAT = "%s:captcha:%s:%s:%s";
    private static final String CAPTCHA_INTERVAL_DATA_KEY_FORMAT = "%s:captcha-interval-date:%s:%s:%s";
    private static final String CAPTCHA_UPPER_LIMIT_KEY_FORMAT = "%s:captcha-upper-limit:%s:%s:%s";

    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {

    }

    public String getCaptchaKey(SmsReqDTO smsReqDTO) {
        return String.format(CAPTCHA_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(), smsReqDTO.getBusinessType(), smsReqDTO.getPhoneNumber());
    }

    public String getCaptchaIntervalDateKey(SmsReqDTO smsReqDTO) {
        return String.format(CAPTCHA_INTERVAL_DATA_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(), smsReqDTO.getBusinessType(), smsReqDTO.getPhoneNumber());
    }

    public String getCaptchaUpperLimitKey(SmsReqDTO smsReqDTO) {
        return String.format(CAPTCHA_UPPER_LIMIT_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(), smsReqDTO.getBusinessType(), smsReqDTO.getPhoneNumber());
    }
}
