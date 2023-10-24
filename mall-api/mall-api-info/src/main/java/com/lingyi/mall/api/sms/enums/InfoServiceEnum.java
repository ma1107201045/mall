package com.lingyi.mall.api.sms.enums;

import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:01
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum InfoServiceEnum {

    /**
     *
     */
    MALL_AUTH_APP(1, "APP认证"),

    UNKNOWN(100, "未知");


    private final Integer code;

    private final String message;


    public static String getMessageByCode(Integer code) {
        return Arrays.stream(values())
                .filter(serviceTypeEnum -> serviceTypeEnum.getCode().equals(code))
                .map(InfoServiceEnum::getMessage)
                .findFirst().orElse(BaseConstant.UNKNOWN);
    }
}
