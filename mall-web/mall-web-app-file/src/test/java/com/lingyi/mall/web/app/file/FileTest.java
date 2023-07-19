package com.lingyi.mall.web.app.file;

import com.lingyi.mall.MallWebAppFileApplicationTest;
import com.lingyi.mall.biz.file.enums.FileTypeEnum;
import com.lingyi.mall.biz.file.service.FileService;
import com.lingyi.mall.biz.file.vo.FileVO;
import com.lingyi.mall.common.base.enums.ClientTypeEnum;
import com.lingyi.mall.common.base.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/19 15:12
 * @description
 */
@SpringBootTest
public class FileTest implements MallWebAppFileApplicationTest {

    @Autowired
    private FileService fileService;

    @Test
    void testFile() {
        FileVO fileVO = fileService.upload(FileUtil.getDirectoryName(ClientTypeEnum.APP, "15038233127"),
                "1.png",
                FileTypeEnum.IMAGE_PNG,
                cn.hutool.core.io.FileUtil.getInputStream("C:\\Users\\Administrator\\Pictures\\1.png"));
        System.out.println(fileVO);
    }
}
