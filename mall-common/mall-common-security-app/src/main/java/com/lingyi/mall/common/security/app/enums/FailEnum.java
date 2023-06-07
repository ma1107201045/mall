package com.lingyi.mall.common.security.app.enums;

import com.lingyi.mall.common.base.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:15
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum FailEnum implements BaseFailEnum {
    /**
     *
     */
    PHONE_NUMBER_NOT_NULL_ERROR(8001, "手机号不能为空"),

    PHONE_NUMBER_NOT_FOUND_ERROR(8002, "手机号不存在");


    private final Integer code;

    private final String message;

}
