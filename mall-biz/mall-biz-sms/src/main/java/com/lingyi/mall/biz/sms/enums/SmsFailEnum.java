package com.lingyi.mall.biz.sms.enums;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 15:21
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum SmsFailEnum implements BaseFailEnum {


    /**
     *
     */
    CAPTCHA_UPPER_LIMIT_ERROR(8001, "验证码发送当日次数已达到上限"),

    CAPTCHA_INTERVAL_DATE_ERROR(8002, "验证码发送频繁"),

    CAPTCHA_EXPIRY_DATE_ERROR(8003, "验证码不存在或者已失效"),

    CAPTCHA_LOG_NULL_ERROR(8002, "验证码日志不能为空");


    private final Integer code;

    private final String message;
}
