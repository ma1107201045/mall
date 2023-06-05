package com.lingyi.mall.common.base.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 15:00
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum OperationType {

    /**
     *
     */
    CREATE(1, "创建"),

    DELETE(2, "删除"),

    UPDATE(3, "更新"),

    READ(4, "读取"),

    OTHER(5, "其他");


    private final Integer code;

    private final String message;
}
