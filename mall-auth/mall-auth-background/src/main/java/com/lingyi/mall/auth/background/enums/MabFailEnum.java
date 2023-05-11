package com.lingyi.mall.auth.background.enums;

import com.lingyi.mall.common.bean.enums.BaseFailEnum;
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
public enum MabFailEnum implements BaseFailEnum {
    /**
     *
     */
    USER_NAME_NOT_NULL_ERROR(8001, "用户名称不能为空"),

    USER_NAME_NOT_FOUND_ERROR(8001, "用户名称不存在");


    private final Integer code;

    private final String message;

}
