package com.lingyi.mall;

import cn.hutool.core.io.FileUtil;
import ink.fengshuai.minio.autoconfigure.MinioFileStorage;
import ink.fengshuai.minio.autoconfigure.objectargs.InputStreamObject;
import io.minio.ObjectWriteResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/26 21:09
 * @Description:
 */
@SpringBootTest
public class FileTest {

    @Autowired
    private MinioFileStorage minioFileStorage;

    @Test
    void test() throws Exception {
        ObjectWriteResponse test = minioFileStorage.putStream("test", new InputStreamObject("111",
                FileUtil.getInputStream("C:\\Users\\86150\\Pictures\\截图\\Snipaste_2022-10-01_23-39-43.png"),"image/png"));
        String url = minioFileStorage.getViewUrl("test", "1.png");
        System.out.println(url);
    }
}
