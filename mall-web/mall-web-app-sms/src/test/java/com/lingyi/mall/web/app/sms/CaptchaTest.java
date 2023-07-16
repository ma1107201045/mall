package com.lingyi.mall.web.app.sms;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.MallWebAppSmsApplicationTest;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.biz.sms.service.CaptchaService;
import com.lingyi.mall.common.base.constant.BaseConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/14 10:52
 * @description
 */
@Slf4j
@SpringBootTest
public class CaptchaTest implements MallWebAppSmsApplicationTest {


    @Autowired
    private CaptchaService captchaService;


    @Test
    public void testCaptchaSend() {
        CaptchaSendReqDTO captchaSendReqDTO = new CaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(ServiceTypeEnum.MALL_AUTH_APP.getCode());
        captchaSendReqDTO.setBusinessType(BusinessTypeEnum.LOGIN.getCode());
        captchaSendReqDTO.setPhoneNumber("15038233127");
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(6));
        captchaSendReqDTO.setLength(6);
        captchaSendReqDTO.setExpiryDate(30);
        captchaSendReqDTO.setIntervalDate(1);
        captchaSendReqDTO.setUpperLimit(10);
        captchaSendReqDTO.setRemark(ServiceTypeEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + BusinessTypeEnum.UNKNOWN.getMessage());
        captchaService.send(captchaSendReqDTO);
    }

    @Test
    public void testThreadCaptchaSend() throws IOException {
        ExecutorService executorService = ThreadUtil.newFixedExecutor(100, StrUtil.EMPTY, false);
        for (int i = 0; i < 100; i++) {
            executorService.submit(this::testCaptchaSend);
        }
        System.in.read();
    }
}
