package com.lingyi.mall.biz.file.service;

import com.lingyi.mall.biz.file.enums.FileTypeEnum;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 20:17
 * @Description:
 */
public interface FileService {


    /**
     * 上传并且获取url
     *
     * @param name 名称
     * @param is   输入流
     * @return url
     */
    String upload(String name, InputStream is);

    /**
     * 上传图片并且获取url
     *
     * @param name          名称
     * @param fileTypeEnum 图片类型
     * @param is            输入流
     * @return 文件id
     */
    String upload(String name, FileTypeEnum fileTypeEnum, InputStream is);

    /**
     * 通过名称删除
     *
     * @param name 文件名
     */
    void delete(String name);

    /**
     * 通过id将文件下载到本地磁盘
     *
     * @param name 名称
     * @param os   输出流
     */
    void download(String name, OutputStream os);


    /**
     * 通过名称获取url
     *
     * @param name id
     * @return url
     */
    String getUrl(String name);

}
