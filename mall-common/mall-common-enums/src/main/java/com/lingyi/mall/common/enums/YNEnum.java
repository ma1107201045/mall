package com.lingyi.mall.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maiweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/05/01 18:52
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum YNEnum {

    Y(1), N(0);

    private final Integer code;
}
