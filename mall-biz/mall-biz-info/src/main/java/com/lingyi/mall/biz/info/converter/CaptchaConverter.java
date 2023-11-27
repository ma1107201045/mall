package com.lingyi.mall.biz.info.converter;

import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.api.info.enums.InfoBusinessEnum;
import com.lingyi.mall.api.info.enums.InfoServiceEnum;
import com.lingyi.mall.biz.info.model.dto.InfoLogDTO;
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

    public InfoLogDTO to(InfoRequest infoReqDTO) {
        var captchaLogDTO = ConverterUtil.to(infoReqDTO, InfoLogDTO.class);
        captchaLogDTO.setServiceName(InfoServiceEnum.getMessageByCode(infoReqDTO.getServiceType()));
        captchaLogDTO.setBusinessName(InfoBusinessEnum.getMessageByCode(infoReqDTO.getBusinessType()));
        return captchaLogDTO;
    }
}
