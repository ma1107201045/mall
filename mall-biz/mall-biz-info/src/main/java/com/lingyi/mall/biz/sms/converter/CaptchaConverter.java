package com.lingyi.mall.biz.sms.converter;

import com.lingyi.mall.api.sms.dto.InfoReqDTO;
import com.lingyi.mall.api.sms.enums.InfoBusinessEnum;
import com.lingyi.mall.api.sms.enums.InfoServiceEnum;
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

    public LogDTO to(InfoReqDTO infoReqDTO) {
        var captchaLogDTO = ConverterUtil.to(infoReqDTO, LogDTO.class);
        captchaLogDTO.setServiceName(InfoServiceEnum.getMessageByCode(infoReqDTO.getServiceType()));
        captchaLogDTO.setBusinessName(InfoBusinessEnum.getMessageByCode(infoReqDTO.getBusinessType()));
        return captchaLogDTO;
    }
}
