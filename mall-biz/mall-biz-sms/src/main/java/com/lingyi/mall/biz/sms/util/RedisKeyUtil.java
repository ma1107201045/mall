package com.lingyi.mall.biz.sms.util;

import com.lingyi.mall.common.base.constant.BaseConstant;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:23
 * @description
 */
@Component
public class RedisKeyUtil {


    public static String getSmsCaptcha(String applicationName, String serviceName, String businessName, String phoneNumber) {
        return applicationName + BaseConstant.COLON_CHAR + serviceName + BaseConstant.COLON_CHAR + businessName + BaseConstant.COLON_CHAR + phoneNumber;
    }
}
