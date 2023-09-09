package com.lingyi.mall.auth.app.util;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:49
 * @description
 */
public class UserNameUtil {

    private static final String USER_NAME_PREFIX = "用户";

    public static String getLeftFourBit(String phoneNumber) {
        return StrUtil.isBlank(phoneNumber) ? ObjectUtil.getNull() : USER_NAME_PREFIX + phoneNumber.substring(0, 4);
    }

    public static String getRightFourBit(String phoneNumber) {
        return StrUtil.isBlank(phoneNumber) ? ObjectUtil.getNull() : USER_NAME_PREFIX + phoneNumber.substring(7);
    }

}
