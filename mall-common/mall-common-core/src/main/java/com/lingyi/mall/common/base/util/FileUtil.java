package com.lingyi.mall.common.base.util;

import cn.hutool.extra.spring.SpringUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.enums.ClientTypeEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/19 14:51
 * @description
 */
public class FileUtil {

    private static final String DIRECTORY_NAME_FORMAT = "%s/%s/%s/%s/%s/%s/%s/%s/%s/";

    public static String getDirectoryName(ClientTypeEnum clientTypeEnum, String username) {
        String applicationName = SpringUtil.getProperty("spring.application.name");
        String nowFormat = LocalDateTime.now().format(DateTimeFormatter.ofPattern(BaseConstant.DATE_TIME_PATTERN));
        String[] splitArr = nowFormat.split(BaseConstant.COLON_CHAR);
        return String.format(DIRECTORY_NAME_FORMAT,
                applicationName,
                clientTypeEnum.toString().toLowerCase(),
                username,
                splitArr[0], splitArr[1], splitArr[2], splitArr[3], splitArr[4], splitArr[5]);
    }
}
