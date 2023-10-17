package com.lingyi.mall.api.sms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 3:28
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum SmsTypeEnum {

    /**
     *
     */
    NOTICE(1, "通知"),

    CAPTCHA(2, "验证码"),

    UNKNOWN(3, "未知");


    private final Integer code;

    private final String message;


}
