package com.lingyi.mall.api.info.enums;

import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 3:28
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum InfoTypeEnum {

    /**
     *
     */
    SMS(1, "短信"),

    SMS_CAPTCHA(2, "短信验证码"),

    EMAIL(3, "邮箱"),

    EMAIL_CAPTCHA(4, "邮箱验证码"),

    UNKNOWN(5, "未知");


    private final Integer code;

    private final String message;

    public static String getMessageByCode(Integer code) {
        return Arrays.stream(values())
                .filter(infoTypeEnum -> infoTypeEnum.getCode().equals(code))
                .map(InfoTypeEnum::getMessage)
                .findFirst().orElse(BaseConstant.UNKNOWN);
    }
}
