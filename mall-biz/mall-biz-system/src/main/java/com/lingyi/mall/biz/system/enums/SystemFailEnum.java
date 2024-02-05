package com.lingyi.mall.biz.system.enums;

import com.lingyi.mall.common.core.enums.BaseFailEnum;
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
public enum SystemFailEnum implements BaseFailEnum {

    /**
     *
     */
    USER_NULL_ERROR(8001, "用户不能为空"),

    USER_NAME_EXIST_ERROR(8002, "用户名称已存在"),

    USER_NAME_ADMIN_CREATE_ERROR(8003, "用户名Admin不允许创建"),

    USER_NAME_ADMIN_DELETE_ERROR(8004, "用户名Admin不允许删除"),

    USER_NAME_ADMIN_UPDATE_ERROR(8005, "用户名Admin不允许更新"),

    ROLE_NULL_ERROR(8006, "角色不能为空"),

    MENU_DIRECTORY_PARENT_ERROR(8007, "目录父级错误"),

    MENU_MENU_PARENT_ERROR(8008, "菜单父级错误"),

    MENU_BUTTON_PARENT_ERROR(8009, "按钮父级错误"),

    MENU_NULL_ERROR(8010, "菜单不能为空"),

    MENU_EXIST_CHILDREN_ERROR(8011, "菜单子级错误"),

    LOG_NULL_ERROR(8011, "日志不能为空");


    private final Integer code;

    private final String message;
}
