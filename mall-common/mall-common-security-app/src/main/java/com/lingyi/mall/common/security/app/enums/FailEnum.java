package com.lingyi.mall.common.security.app.enums;

import com.lingyi.mall.common.base.enums.BaseFail;
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
public enum FailEnum implements BaseFail {
    /**
     *
     */
    USER_NAME_NOT_NULL_ERROR(8001, "用户名称不能为空"),

    USER_NAME_NOT_FOUND_ERROR(8001, "用户名称不存在");


    private final Integer code;

    private final String message;

}
