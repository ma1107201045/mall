package com.lingyi.mall.auth.background.enums;

import com.lingyi.mall.common.enums.BaseFailEnum;
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
    USER_NAME_NOT_FOUND_ERROR(8001, "用户信息不能为空");

    private final Integer code;

    private final String msg;

}
