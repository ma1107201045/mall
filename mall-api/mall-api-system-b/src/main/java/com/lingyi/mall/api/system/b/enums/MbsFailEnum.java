package com.lingyi.mall.api.system.b.enums;

import com.lingyi.mall.common.bean.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 17:27
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum MbsFailEnum implements BaseFailEnum {

    /**
     *
     */
    USER_NAME_EXIST_ERROR(8002, "用户名称已存在");


    private final Integer code;

    private final String message;
}
