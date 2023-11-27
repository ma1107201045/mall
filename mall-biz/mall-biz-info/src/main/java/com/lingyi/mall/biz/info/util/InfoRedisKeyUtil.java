package com.lingyi.mall.biz.info.util;

import com.lingyi.mall.api.info.request.AbstractInfoRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:23
 * @description
 */
@Component
public final class InfoRedisKeyUtil {

    private static final String INTERVAL_TIME_KEY_FORMAT = "%s:info-interval-time:%s:%s:%s:%s";
    private static final String UPPER_LIMIT_KEY_FORMAT = "%s:info-upper-limit:%s:%s:%s:%s";
    private static final String CAPTCHA_KEY_FORMAT = "%s:info-captcha:%s:%s:%s:%s";

    @Value("${spring.application.name}")
    private String applicationName;

    public String getUpperLimitKey(InfoRequest infoReqDTO) {
        return String.format(INTERVAL_TIME_KEY_FORMAT, applicationName,
                infoReqDTO.getServiceType(),
                infoReqDTO.getBusinessType(),
                infoReqDTO.getType(),
                infoReqDTO.getNumber());
    }


    public String getIntervalTimeKey(InfoRequest infoReqDTO) {
        return String.format(UPPER_LIMIT_KEY_FORMAT, applicationName,
                infoReqDTO.getServiceType(),
                infoReqDTO.getBusinessType(),
                infoReqDTO.getType(),
                infoReqDTO.getNumber());

    }


    public String getCaptchaKey(AbstractInfoRequest abstractInfoRequest) {
        return String.format(CAPTCHA_KEY_FORMAT, applicationName,
                abstractInfoRequest.getServiceType(),
                abstractInfoRequest.getBusinessType(),
                abstractInfoRequest.getType(),
                abstractInfoRequest.getNumber());
    }

}
