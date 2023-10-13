package com.lingyi.mall.biz.file.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.lingyi.mall.biz.file.enums.FileFailEnum;
import com.lingyi.mall.biz.file.enums.FileTypeEnum;
import com.lingyi.mall.biz.file.exception.FileException;
import com.lingyi.mall.biz.file.service.FileService;
import com.lingyi.mall.biz.file.model.vo.FileVO;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
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


    @Value("${file.base-url}")
    private String baseUrl;

    @Value("${minio.bucket}")
    private String bucket;

    private final MinioFileStorage minioFileStorage;


    @Override
    public FileVO upload(String directoryName, String name, InputStream is) {
        return upload(directoryName, name, FileTypeEnum.FILE, is);
    }

    @Override
    public void delete(String name) {
        try {
            minioFileStorage.removeFile(bucket, name);
        } catch (Exception e) {
            log.error("delete error ", e);
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
            log.error("download error ", e);
            throw new FileException(FileFailEnum.DOWNLOAD_FILE_ERROR);
        }
    }

    @Override
    public FileVO getUrl(String name) {
        try {
            String url = minioFileStorage.getViewUrl(bucket, name);
            return FileVO.of(getNotExpiryDateUrl(url));
        } catch (Exception e) {
            log.error("get url error", e);
            return ObjectUtil.getNull();
        }
    }

    @Override
    public FileVO upload(String directoryName, String name, FileTypeEnum fileTypeEnum, InputStream is) {
        try {
            boolean flag = creatBucketOfNotExist(bucket);
            AssertUtil.isTrue(flag, FileFailEnum.UPLOAD_FILE_ERROR);
            //名称
            String actualName = directoryName + IdUtil.fastSimpleUUID() + BaseConstant.POINT_CHAR + FileUtil.extName(name);
            //上传
            minioFileStorage.putStream(bucket, new InputStreamObject(actualName, is, fileTypeEnum.getContentType()));
            //获取url
            String url = minioFileStorage.getViewUrl(bucket, actualName);
            return FileVO.of(baseUrl, getNotExpiryDateUrl(url), name);
        } catch (Exception e) {
            log.error("upload error ", e);
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

    private String getNotExpiryDateUrl(String url) {
        return url.split(BaseConstant.QUESTION_CHAR_REGEX)[0];
    }

}
