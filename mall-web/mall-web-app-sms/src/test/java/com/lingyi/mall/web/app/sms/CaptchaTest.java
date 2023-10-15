package com.lingyi.mall.web.app.sms;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.MallWebAppSmsApplicationTest;
import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.api.sms.enums.BusinessTypeEnum;
import com.lingyi.mall.api.sms.enums.ServiceTypeEnum;
import com.lingyi.mall.api.sms.enums.TypeEnum;
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
    private SmsService captchaService;


    @Test
    public void testCaptchaSend() {
        SmsReqDTO smsReqDTO = new SmsReqDTO();
        smsReqDTO.setServiceType(ServiceTypeEnum.MALL_AUTH_APP.getCode());
        smsReqDTO.setBusinessType(BusinessTypeEnum.LOGIN.getCode());
        smsReqDTO.setType(TypeEnum.CAPTCHA.getCode());
        smsReqDTO.setPhoneNumber("15038233127");
        smsReqDTO.setCaptcha(RandomUtil.randomNumbers(6));
        smsReqDTO.setLength(6);
        smsReqDTO.setExpiryDate(30);
        smsReqDTO.setIntervalDate(1);
        smsReqDTO.setUpperLimit(10);
        smsReqDTO.setRemark(ServiceTypeEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + BusinessTypeEnum.UNKNOWN.getMessage());
        captchaService.send(smsReqDTO);
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
