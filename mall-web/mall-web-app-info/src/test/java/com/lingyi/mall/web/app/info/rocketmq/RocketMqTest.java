package com.lingyi.mall.web.app.info.rocketmq;

import com.lingyi.mall.MallWebAppInfoApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class RocketMqTest implements MallWebAppInfoApplicationTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Value("${rocketmq.pull-consumer.topic}")
    private String pullConsumerTopic;

    @Test
    public void testSendMessage() throws IOException {
        rocketMQTemplate.send(pullConsumerTopic, new Message<>() {
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
        log.info("发送消息成功");
        System.in.read();
    }

    @Test
    public void testAsyncSendMessage() throws IOException {
        rocketMQTemplate.asyncSend(pullConsumerTopic, new Message<>() {
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
        log.info("发送异步消息成功");
        System.in.read();
    }
}
