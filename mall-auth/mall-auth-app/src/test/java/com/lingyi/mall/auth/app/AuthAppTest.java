package com.lingyi.mall.auth.app;


import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.MallAuthAppApplicationTest;
import com.lingyi.mall.auth.app.model.dto.AuthAppSmsLoginDTO;
import com.lingyi.mall.auth.app.model.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.model.vo.AuthAppLoginVO;
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
public class AuthAppTest implements MallAuthAppApplicationTest {


    @Autowired
    private AuthAppService authAppService;

    @Test
    public void testSendSmsCaptcha() {
        AuthAppSendDTO authAppSendDTO = new AuthAppSendDTO();
        authAppSendDTO.setNumber("15038233127");
        authAppService.sendCaptcha(authAppSendDTO);
    }

    @Test
    public void testLogin() {
        AuthAppSmsLoginDTO authAppSmsLoginDTO = new AuthAppSmsLoginDTO();
        authAppSmsLoginDTO.setPhoneNumber("15038233127");
        authAppSmsLoginDTO.setSmsCaptcha("376295");
        AuthAppLoginVO authAppLoginVO = authAppService.smsLogin(authAppSmsLoginDTO);
        log.info(JSON.toJSONString(authAppLoginVO));
    }
}
