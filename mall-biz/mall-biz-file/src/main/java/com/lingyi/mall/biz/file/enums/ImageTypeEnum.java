package com.lingyi.mall.biz.file.enums;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.util.ObjectUtil;
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
public enum ImageTypeEnum {
    /**
     *
     */
    JPEG("jpeg", "image/jpeg"),

    PNG("png", "image/png");

    private final String name;

    private final String contentType;


    /**
     * 通过文件名称获取contentType
     *
     * @param fileName 文件名称
     * @return contentType
     */
    public static ImageTypeEnum getContentTypeByFileName(String fileName) {
        var extName = FileUtil.extName(fileName);
        if (Objects.isNull(extName)) {
            return JPEG;
        }
        ImageTypeEnum imageTypeEnum = Arrays
                .stream(values())
                .filter(imageType -> imageType.name.equals(extName))
                .findAny()
                .orElse(ObjectUtil.getNull());
        return Objects.isNull(imageTypeEnum) ? ImageTypeEnum.JPEG : imageTypeEnum;
    }
}
