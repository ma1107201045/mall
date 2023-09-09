package com.lingyi.mall.biz.member.enums;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
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

    MEMBER_NULL_ERROR(8001, "会员不能为空"),

    MEMBER_LEVEL_NULL_ERROR(8002, "会员等级不能为空"),

    MEMBER_LOGIN_LOG_NULL_ERROR(8002, "会员登录日志不能为空");

    private final Integer code;

    private final String message;
}
