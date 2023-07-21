package com.lingyi.mall.auth.app.enums;

import com.lingyi.mall.common.base.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/21 10:01
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum AppFailEnum implements BaseFailEnum {

    MEMBER_DEFAULT_LEVEL_ID_NULL_ERROR(8001, "会员默认等级id不能为空");

    private final Integer code;

    private final String message;
}
