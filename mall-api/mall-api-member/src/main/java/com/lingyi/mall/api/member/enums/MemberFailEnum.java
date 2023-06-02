package com.lingyi.mall.api.member.enums;

import com.lingyi.mall.common.base.enums.BaseFailEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/2 15:38
 * @description
 */
@Getter
@RequiredArgsConstructor
public enum MemberFailEnum implements BaseFailEnum {

    MEMBER_NULL_ERROR(8001, "会员不能为空");


    private final Integer code;

    private final String message;
}
