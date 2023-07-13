package com.lingyi.mall.biz.sms.enums;

import com.lingyi.mall.common.base.enums.BaseFailEnum;
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
    CAPTCHA_LOG_NULL_ERROR(8001, "验证码日志不能为空");


    private final Integer code;

    private final String message;
}
