package com.lingyi.mall.biz.file.enums;

import cn.hutool.core.io.FileUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/27 20:31
 * @Description:
 */

@Getter
@RequiredArgsConstructor
public enum FileTypeEnum {
    /**
     *
     */
    IMAGE_JPEG("jpeg", "image/jpeg"),

    IMAGE_JPG("jpg", "image/jpg"),

    IMAGE_PNG("png", "image/png"),

    FILE("*", "application/octet-stream");

    private final String name;

    private final String contentType;


    /**
     * 通过文件名称获取contentType
     *
     * @param fileName 文件名称
     * @return contentType
     */
    public static FileTypeEnum getContentTypeByFileName(String fileName) {
        var extName = FileUtil.extName(fileName);
        if (Objects.isNull(extName)) {
            return FILE;
        }
        FileTypeEnum fileTypeEnum = Arrays.stream(values())
                .filter(fileType -> fileType.name.equals(extName))
                .findAny()
                .orElse(ObjectUtil.getNull());
        return Objects.isNull(fileTypeEnum) ? FileTypeEnum.FILE : fileTypeEnum;
    }
}
