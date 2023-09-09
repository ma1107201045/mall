package com.lingyi.mall.biz.file.enums;

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
public enum FileFailEnum implements BaseFailEnum {

    /**
     *
     */
    UPLOAD_FILE_ERROR(8001, "上传文件错误"),

    DOWNLOAD_FILE_ERROR(8002, "下载文件错误"),

    DELETE_FILE_ERROR(8003, "删除文件错误");

    private final Integer code;

    private final String message;
}
