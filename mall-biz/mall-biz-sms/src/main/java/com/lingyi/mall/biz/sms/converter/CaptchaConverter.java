package com.lingyi.mall.biz.sms.converter;

import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.biz.sms.model.dto.LogDTO;
import com.lingyi.mall.common.core.util.ConverterUtil;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/11 15:42
 * @description
 */
public final class CaptchaConverter {

    public static final CaptchaConverter INSTANCE = new CaptchaConverter();

    private CaptchaConverter() {

    }

    public LogDTO to(SmsReqDTO smsReqDTO) {
        var captchaLogDTO = ConverterUtil.to(smsReqDTO, LogDTO.class);
        captchaLogDTO.setServiceName(ServiceTypeEnum.getMessageByCode(smsReqDTO.getServiceType()));
        captchaLogDTO.setBusinessName(BusinessTypeEnum.getMessageByCode(smsReqDTO.getBusinessType()));
        return captchaLogDTO;
    }
}
