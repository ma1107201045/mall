package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.api.sms.dto.AbstractSmsReqDTO;
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

    private static final String SMS_INTERVAL_TIME_KEY_FORMAT = "%s:sms-interval-time:%s:%s:%s:%s";
    private static final String SMS_UPPER_LIMIT_KEY_FORMAT = "%s:sms-upper-limit:%s:%s:%s:%s";
    private static final String SMS_CAPTCHA_KEY_FORMAT = "%s:sms-captcha:%s:%s:%s:%s";

    @Value("${spring.application.name}")
    private String applicationName;

    public String getUpperLimitKey(SmsReqDTO smsReqDTO) {
        return String.format(SMS_UPPER_LIMIT_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(),
                smsReqDTO.getBusinessType(),
                smsReqDTO.getType(),
                smsReqDTO.getPhoneNumber());
    }


    public String getIntervalTimeKey(SmsReqDTO smsReqDTO) {
        return String.format(SMS_INTERVAL_TIME_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(),
                smsReqDTO.getBusinessType(),
                smsReqDTO.getType(),
                smsReqDTO.getPhoneNumber());

    }


    public String getSmsCaptchaKey(AbstractSmsReqDTO abstractSmsReqDTO) {
        return String.format(SMS_CAPTCHA_KEY_FORMAT, applicationName,
                abstractSmsReqDTO.getServiceType(),
                abstractSmsReqDTO.getBusinessType(),
                abstractSmsReqDTO.getType(),
                abstractSmsReqDTO.getPhoneNumber());
    }

}
