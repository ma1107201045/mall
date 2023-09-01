package com.lingyi.mall.biz.sms.converter;

import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.common.base.util.ConverterUtil;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/11 15:42
 * @description
 */
public class CaptchaConverter {

    public static final CaptchaConverter INSTANCE = new CaptchaConverter();

    private CaptchaConverter() {

    }

    public CaptchaLogDO to(CaptchaSendReqDTO captchaSendReqDTO) {
        var captchaLogDO = ConverterUtil.to(captchaSendReqDTO, CaptchaLogDO.class);
        captchaLogDO.setServiceName(ServiceTypeEnum.getMessageByCode(captchaSendReqDTO.getServiceType()));
        captchaLogDO.setBusinessName(BusinessTypeEnum.getMessageByCode(captchaSendReqDTO.getBusinessType()));
        return captchaLogDO;
    }
}
