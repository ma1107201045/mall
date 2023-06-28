package com.lingyi.mall.biz.file.service.impl;

import com.lingyi.mall.biz.file.enums.FileFailEnum;
import com.lingyi.mall.biz.file.enums.FileTypeEnum;
import com.lingyi.mall.biz.file.exception.FileException;
import com.lingyi.mall.biz.file.service.FileService;
import com.lingyi.mall.common.base.util.AssertUtil;
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
public class MinioFileServiceImpl implements FileService {

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioFileStorage minioFileStorage;


    @Override
    public String upload(String name, InputStream is) {
        return upload(name, FileTypeEnum.FILE, is);
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
    public String upload(String name, FileTypeEnum fileTypeEnum, InputStream is) {
        try {
            boolean flag = creatBucketOfNotExist(bucket);
            AssertUtil.isTrue(flag, FileFailEnum.UPLOAD_FILE_ERROR);
            minioFileStorage.putStream(bucket, new InputStreamObject(name, is, fileTypeEnum.getContentType()));
            return minioFileStorage.getViewUrl(bucket, name);
        } catch (Exception e) {
            throw new FileException(FileFailEnum.UPLOAD_FILE_ERROR);
        }
    }

    private boolean creatBucketOfNotExist(String bucket) {
        try {
            var isExistBucket = minioFileStorage.isExistBucket(bucket);
            if (!isExistBucket) {
                minioFileStorage.createBucket(bucket);
            }
            return true;
        } catch (Exception e) {
            log.error("create bucket error ", e);
            return false;
        }
    }

}
