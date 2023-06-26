package com.lingyi.mall.biz.file.service;

import java.io.File;
import java.io.InputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 20:17
 * @Description:
 */
public interface FileService {


    /**
     * 通过输入流上传到文件服务器并拿到id
     *
     * @param is   输入流
     * @param name 文件名称
     * @return 文件id
     */
    String upload(InputStream is, String name);

    /**
     * 通过id删除文件
     *
     * @param id id
     */
    void delete(String id);

    /**
     * 通过id将文件下载到本地磁盘
     *
     * @param id       id
     * @param fullName 存储的本地磁盘的文件名
     */
    void download(String id, String fullName);


    /**
     * 通过id获取url
     *
     * @param id id
     * @return url
     */
    String getUrl(String id);

}
