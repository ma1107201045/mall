package com.lingyi.mall.auth.app;


import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.MallAuthAppApplicationTest;
import com.lingyi.mall.auth.app.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.vo.AuthAppLoginVO;
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
        authAppSendDTO.setPhoneNumber("15038233127");
        authAppService.send(authAppSendDTO);
    }

    @Test
    public void testLogin() {
        AuthAppLoginDTO authAppLoginDTO = new AuthAppLoginDTO();
        authAppLoginDTO.setPhoneNumber("15038233127");
        authAppLoginDTO.setSmsCaptcha("376295");
        AuthAppLoginVO authAppLoginVO = authAppService.login(authAppLoginDTO);
        log.info(JSON.toJSONString(authAppLoginVO));
    }
}
