package com.lingyi.mall.biz.file.service.impl;

import com.lingyi.mall.biz.file.service.FileService;
import ink.fengshuai.minio.autoconfigure.MinioFileStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 20:23
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MinioFileServiceImpl implements FileService {

    private final MinioFileStorage minioFileStorage;


    @Override
    public String upload(InputStream is, String name) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void download(String id, String fullName) {

    }

    @Override
    public String getUrl(String id) {
        return null;
    }
}
