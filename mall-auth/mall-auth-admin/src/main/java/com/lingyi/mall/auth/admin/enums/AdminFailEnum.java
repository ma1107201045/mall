package com.lingyi.mall.auth.admin.enums;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/10 9:19
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum AdminFailEnum implements BaseFailEnum {

    IMAGE_CAPTCHA_STALE_DATED_ERROR(1001, "图形验证码过期"),

    IMAGE_CAPTCHA_ERROR(1001, "图形验证码错误"),

    USER_NAME_NOT_EXIST_ERROR(1002, "用户名不存在"),

    PASSWORD_ERROR(1003, "密码错误"),

    GET_IMAGE_CAPTCHA_ERROR(1004, "获取验证码异常"),

    SET_IMAGE_CAPTCHA_ERROR(1005, "设置验证码异常");

    private final Integer code;

    private final String message;
}
