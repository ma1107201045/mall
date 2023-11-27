package com.lingyi.mall.web.app.info;

import cn.hutool.core.util.RandomUtil;
import com.lingyi.mall.MallWebAppInfoApplicationTest;
import com.lingyi.mall.api.info.request.InfoCaptchaSendRequest;
import com.lingyi.mall.api.info.request.InfoRequest;
import com.lingyi.mall.api.info.enums.InfoBusinessEnum;
import com.lingyi.mall.api.info.enums.InfoServiceEnum;
import com.lingyi.mall.api.info.enums.InfoTypeEnum;
import com.lingyi.mall.biz.info.service.InfoService;
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
public class InfoTest implements MallWebAppInfoApplicationTest {


    @Autowired
    private InfoService infoService;
    private static final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    @Test
    public void testSend() throws ExecutionException, InterruptedException {
        InfoRequest smsReqDTO = new InfoRequest();
        smsReqDTO.setServiceType(InfoServiceEnum.MALL_AUTH_APP.getCode());
        smsReqDTO.setBusinessType(InfoBusinessEnum.ORDER.getCode());
        smsReqDTO.setType(InfoTypeEnum.SMS.getCode());
        smsReqDTO.setNumber("15038233127");
        smsReqDTO.setIntervalTime(1);
        smsReqDTO.setUpperLimit(10);
        smsReqDTO.setContent("尊敬的用户您好，您的订单已取消，请及时查看");
        smsReqDTO.setRemark(InfoServiceEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + InfoBusinessEnum.UNKNOWN.getMessage());
        CompletableFuture<?>[] completableFutures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> infoService.send(smsReqDTO), executorService);
            completableFutures[i] = completableFuture;
        }

        CompletableFuture.allOf(completableFutures).get();
        System.out.println("all send success");
    }

    @Test
    public void testSendCaptcha() throws ExecutionException, InterruptedException {
        InfoCaptchaSendRequest captchaSendReqDTO = new InfoCaptchaSendRequest();
        captchaSendReqDTO.setServiceType(InfoServiceEnum.MALL_AUTH_APP.getCode());
        captchaSendReqDTO.setBusinessType(InfoBusinessEnum.LOGIN.getCode());
        captchaSendReqDTO.setType(InfoTypeEnum.SMS_CAPTCHA.getCode());
        captchaSendReqDTO.setNumber("15038233127");
        captchaSendReqDTO.setIntervalTime(1);
        captchaSendReqDTO.setUpperLimit(10);
        captchaSendReqDTO.setCaptcha(RandomUtil.randomNumbers(6));
        captchaSendReqDTO.setCaptchaLength(6);
        captchaSendReqDTO.setCaptchaExpiryDate(30);
        captchaSendReqDTO.setContent("登录验证码为548629，防止泄露");
        captchaSendReqDTO.setRemark(InfoServiceEnum.UNKNOWN.getMessage() + BaseConstant.COLON_CHAR + InfoBusinessEnum.UNKNOWN.getMessage());
        CompletableFuture<?>[] completableFutures = new CompletableFuture[100];
        for (int i = 0; i < 100; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> infoService.sendCaptcha(captchaSendReqDTO), executorService);
            completableFutures[i] = completableFuture;
        }
        CompletableFuture.allOf(completableFutures).get();
        System.out.println("all send success");
    }
}
