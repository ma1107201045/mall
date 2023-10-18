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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
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
public class SmsTest implements MallWebAppSmsApplicationTest {


    @Autowired
    private SmsService smsService;
    private static final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    @Test
    public void testSend() throws ExecutionException, InterruptedException {
        SmsReqDTO smsReqDTO = new SmsReqDTO();
        smsReqDTO.setServiceType(SmsServiceEnum.MALL_AUTH_APP.getCode());
        smsReqDTO.setBusinessType(SmsBusinessEnum.ORDER.getCode());
        smsReqDTO.setType(SmsTypeEnum.NOTICE.getCode());
        smsReqDTO.setPhoneNumber("15038233127");
        smsReqDTO.setIntervalTime(1);
        smsReqDTO.setUpperLimit(10);
        smsReqDTO.setContent("尊敬的用户您好，您的订单已取消，请及时查看");
        smsReqDTO.setRemark(SmsServiceEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + SmsBusinessEnum.UNKNOWN.getMessage());
        CompletableFuture<?>[] completableFutures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> smsService.send(smsReqDTO), executorService);
            completableFutures[i] = completableFuture;
        }

        CompletableFuture.allOf(completableFutures).get();
        System.out.println("all send success");
    }

    @Test
    public void testSendCaptcha() throws ExecutionException, InterruptedException {
        CaptchaSendReqDTO captchaSendReqDTO = new CaptchaSendReqDTO();
        captchaSendReqDTO.setServiceType(SmsServiceEnum.MALL_AUTH_APP.getCode());
        captchaSendReqDTO.setBusinessType(SmsBusinessEnum.LOGIN.getCode());
        captchaSendReqDTO.setType(SmsTypeEnum.CAPTCHA.getCode());
        captchaSendReqDTO.setPhoneNumber("15038233127");
        captchaSendReqDTO.setIntervalTime(1);
        captchaSendReqDTO.setUpperLimit(10);
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(6));
        captchaSendReqDTO.setCaptchaLength(6);
        captchaSendReqDTO.setCaptchaExpiryDate(30);
        captchaSendReqDTO.setContent("登录验证码为548629，防止泄露");
        captchaSendReqDTO.setRemark(SmsServiceEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + SmsBusinessEnum.UNKNOWN.getMessage());
        CompletableFuture<?>[] completableFutures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> smsService.sendCaptcha(captchaSendReqDTO), executorService);
            completableFutures[i] = completableFuture;
        }
        CompletableFuture.allOf(completableFutures).get();
        System.out.println("all send success");
    }
}
