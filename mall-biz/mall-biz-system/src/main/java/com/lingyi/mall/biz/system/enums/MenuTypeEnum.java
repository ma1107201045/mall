package com.lingyi.mall.biz.system.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/4 20:53
 * @Description:
 */
@Getter
@RequiredArgsConstructor
public enum MenuTypeEnum {

    /**
     * 目录
     */
    DIRECTORY(1, "目录"),
    /**
     * 菜单
     */
    MENU(2, "菜单"),
    /**
     * 按钮
     */
    BUTTON(3, "按钮");

    private final Integer code;

    private final String message;
}
