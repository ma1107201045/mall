package com.lingyi.mall.common.base.util;

import cn.hutool.extra.spring.SpringUtil;
import com.lingyi.mall.common.base.enums.ClientTypeEnum;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/19 14:51
 * @description
 */
public class FileUtil {

    private static final String DIRECTORY_NAME_FORMAT = "%s/%s/%s/%d/%d/%d/%d/%d/%d/";

    public static String getDirectoryName(ClientTypeEnum clientTypeEnum, String username) {
        String applicationName = SpringUtil.getProperty("spring.application.name");
        LocalDateTime now = LocalDateTime.now();
        return String.format(DIRECTORY_NAME_FORMAT, applicationName, clientTypeEnum.toString().toLowerCase(), username, now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond());
    }
}
