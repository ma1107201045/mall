package com.lingyi.mall.biz.file.util;

import cn.hutool.extra.spring.SpringUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/19 14:51
 * @description
 */
public class FileUtil {

    private static final String DATE_TIME_PATTERN = "yyyy:MM:dd:HH:mm:ss";
    private static final String DIRECTORY_NAME_FORMAT = "%s/%s/%s/%s/%s/%s/%s/%s/%s/";

    public static String getDirectoryName(String clientType, String username) {
        var applicationName = SpringUtil.getProperty("spring.application.name");
        var nowDateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        var splitArr = nowDateTimeStr.split(BaseConstant.COLON_CHAR);
        return String.format(DIRECTORY_NAME_FORMAT,
                applicationName,
                clientType.toLowerCase(),
                username,
                splitArr[0], splitArr[1], splitArr[2], splitArr[3], splitArr[4], splitArr[5]);
    }
}
