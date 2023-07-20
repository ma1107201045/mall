package com.lingyi.mall.web.app.sms;

import com.lingyi.mall.MallWebAppSmsApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.IOException;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/20 10:08
 * @description
 */
@Slf4j
@SpringBootTest
public class RocketMqTest implements MallWebAppSmsApplicationTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testSendMessage() {
        rocketMQTemplate.send("Topic01", new Message<>() {
            @NotNull
            @Override
            public Object getPayload() {
                return "Hello World !!";
            }

            @NotNull
            @Override
            public MessageHeaders getHeaders() {
                return new MessageHeaders(null);
            }
        });

    }

    @Test
    public void testAsyncSendMessage() throws IOException {
        rocketMQTemplate.asyncSend("Topic02", new Message<>() {
            @NotNull
            @Override
            public Object getPayload() {
                return "Hello World !!";
            }

            @NotNull
            @Override
            public MessageHeaders getHeaders() {
                return new MessageHeaders(null);
            }
        }, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("sendResult:{}", sendResult.toString());
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("sendError:", throwable);
            }
        });
        System.in.read();
    }
}
