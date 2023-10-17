package com.lingyi.mall.api.sms.enums;

import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 10:04
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum SmsBusinessEnum {

    /*
     *
     */
    LOGIN(1, "登录验证码"),

    ORDER(2, "订单通知"),

    UNKNOWN(100, "未知");

    private final Integer code;

    private final String message;

    public static String getMessageByCode(Integer code) {
        return Arrays.stream(values())
                .filter(businessTypeEnum -> businessTypeEnum.getCode().equals(code))
                .map(SmsBusinessEnum::getMessage)
                .findFirst().orElse(BaseConstant.UNKNOWN);
    }
}
