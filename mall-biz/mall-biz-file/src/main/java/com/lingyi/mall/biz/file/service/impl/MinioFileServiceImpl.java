package com.lingyi.mall.biz.file.service.impl;

import cn.hutool.http.ContentType;
import com.lingyi.mall.biz.file.enums.FileFailEnum;
import com.lingyi.mall.biz.file.enums.ImageTypeEnum;
import com.lingyi.mall.biz.file.exception.FileException;
import com.lingyi.mall.biz.file.service.ImageFileService;
import com.lingyi.mall.common.util.ObjectUtil;
import ink.fengshuai.minio.autoconfigure.MinioFileStorage;
import ink.fengshuai.minio.autoconfigure.objectargs.InputStreamObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 20:23
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MinioFileServiceImpl implements ImageFileService {

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioFileStorage minioFileStorage;


    @Override
    public String upload(String name, InputStream is) {
        try {
            minioFileStorage.putStream(bucket, new InputStreamObject(name, is));
            return minioFileStorage.getViewUrl(bucket, name);
        } catch (Exception e) {
            throw new FileException(FileFailEnum.UPLOAD_FILE_ERROR);
        }
    }

    @Override
    public void delete(String name) {
        try {
            minioFileStorage.removeFile(bucket, name);
        } catch (Exception e) {
            throw new FileException(FileFailEnum.DELETE_FILE_ERROR);
        }
    }

    @Override
    public void download(String name, OutputStream os) {
        try {
            minioFileStorage.getStreamToRead(bucket, name, inputStream -> {
                try {
                    os.write(inputStream.readAllBytes());
                } catch (IOException e) {
                    throw new FileException(FileFailEnum.DOWNLOAD_FILE_ERROR);
                }
            });
        } catch (Exception e) {
            throw new FileException(FileFailEnum.DOWNLOAD_FILE_ERROR);
        }
    }

    @Override
    public String getUrl(String name) {
        try {
            return minioFileStorage.getViewUrl(bucket, name);
        } catch (Exception e) {
            log.error("获取url出错", e);
            return ObjectUtil.getNull();
        }
    }

    @Override
    public String upload(String name, ImageTypeEnum imageTypeEnum, InputStream is) {
        try {
            minioFileStorage.putStream(bucket, new InputStreamObject(name, is, imageTypeEnum.getContentType()));
            return minioFileStorage.getViewUrl(bucket, name);
        } catch (Exception e) {
            throw new FileException(FileFailEnum.UPLOAD_FILE_ERROR);
        }
    }
}
