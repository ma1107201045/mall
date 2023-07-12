package com.lingyi.mall.biz.member.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:43
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum RegisterSourceEnum {

    H5(1, "h5端"),

    ANDROID(2, "Android端"),

    IOS(3, "IOS端"),

    PC(4, "PC端");

    private final Integer code;

    private final String message;
}
