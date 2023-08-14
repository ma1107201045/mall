package com.lingyi.mall.auth.app;


import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.MallAuthAppApplicationTest;
import com.lingyi.mall.auth.app.dto.AppLoginDTO;
import com.lingyi.mall.auth.app.dto.AppSendDTO;
import com.lingyi.mall.auth.app.service.AppService;
import com.lingyi.mall.auth.app.vo.AppLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/18 10:11
 * @description
 */
@Slf4j
@SpringBootTest
public class AppTest implements MallAuthAppApplicationTest {


    @Autowired
    private AppService appService;

    @Test
    public void testSendSmsCaptcha() {
        AppSendDTO appSendDTO = new AppSendDTO();
        appSendDTO.setPhoneNumber("15038233127");
        appService.send(appSendDTO);
    }

    @Test
    public void testLogin() {
        AppLoginDTO appLoginDTO = new AppLoginDTO();
        appLoginDTO.setPhoneNumber("15038233127");
        appLoginDTO.setSmsCaptcha("376295");
        AppLoginVO appLoginVO = appService.login(appLoginDTO);
        log.info(JSON.toJSONString(appLoginVO));
    }
}
