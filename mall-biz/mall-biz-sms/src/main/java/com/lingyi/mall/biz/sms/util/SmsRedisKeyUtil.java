package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.api.sms.dto.AbstractDTO;
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

    private static final String SMS_INTERVAL_KEY_FORMAT = "%s:sms-interval:%s:%s:%s";
    private static final String SMS_UPPER_LIMIT_KEY_FORMAT = "%s:sms-upper-limit:%s:%s:%s";
    private static final String CAPTCHA_KEY_FORMAT = "%s:captcha:%s:%s:%s";

    @Value("${spring.application.name}")
    private String applicationName;


    public String getSmsIntervalKey(SmsReqDTO smsReqDTO) {
        return String.format(SMS_INTERVAL_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(),
                smsReqDTO.getBusinessType(),
                smsReqDTO.getPhoneNumber());
    }

    public String getSmsUpperLimitKey(SmsReqDTO smsReqDTO) {
        return String.format(SMS_UPPER_LIMIT_KEY_FORMAT, applicationName,
                smsReqDTO.getServiceType(),
                smsReqDTO.getBusinessType(),
                smsReqDTO.getPhoneNumber());
    }


    public String getCaptchaKey(AbstractDTO abstractDTO) {
        return String.format(CAPTCHA_KEY_FORMAT, applicationName,
                abstractDTO.getServiceType(),
                abstractDTO.getBusinessType(),
                abstractDTO.getPhoneNumber());
    }

}
