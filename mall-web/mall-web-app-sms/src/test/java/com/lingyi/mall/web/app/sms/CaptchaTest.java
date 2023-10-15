package com.lingyi.mall.web.app.sms;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.MallWebAppSmsApplicationTest;
import com.lingyi.mall.api.sms.dto.CaptchaSendReqDTO;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.enums.SmsBusinessEnum;
import com.lingyi.mall.api.sms.enums.SmsServiceEnum;
import com.lingyi.mall.api.sms.enums.SmsTypeEnum;
import com.lingyi.mall.biz.sms.service.SmsService;
import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private SmsService smsService;


    @Test
    public void testCaptchaSend() {
        CaptchaSendReqDTO captchaSendReqDTO = new CaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(SmsServiceEnum.MALL_AUTH_APP.getCode());
        captchaSendReqDTO.setBusinessType(SmsBusinessEnum.LOGIN.getCode());
        captchaSendReqDTO.setType(SmsTypeEnum.CAPTCHA.getCode());
        captchaSendReqDTO.setPhoneNumber("15038233127");
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(6));
        captchaSendReqDTO.setCaptchaLength(6);
        captchaSendReqDTO.setCaptchaExpiryDate(30);
        captchaSendReqDTO.setInterval(1);
        captchaSendReqDTO.setUpperLimit(10);
        captchaSendReqDTO.setRemark(SmsServiceEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + SmsBusinessEnum.UNKNOWN.getMessage());
        smsService.send(captchaSendReqDTO);
    }

    @Test
    public void testThreadCaptchaSend() throws IOException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 100; i++) {
            executorService.submit(this::testCaptchaSend);
        }
        System.in.read();
    }
}
