package com.lingyi.mall.biz.file.service;

import com.lingyi.mall.biz.file.enums.ImageTypeEnum;

import java.io.InputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/27 20:28
 * @Description:
 */
public interface ImageFileService extends FileService {

    /**
     * 上传并且获取url
     *
     * @param name          名称
     * @param imageTypeEnum 类型
     * @param is            输入流
     * @return 文件id
     */
    String upload(String name, ImageTypeEnum imageTypeEnum, InputStream is);

}
