package com.lingyi.mall.common.mq.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/20 9:35
 * @description
 */
@Slf4j
@Component
@EnableRetry
@RequiredArgsConstructor
public class RocketMqUtil {

    private final RocketMQTemplate rocketMQTemplate;

    /*出现指定异常时(RuntimeException) ,再重试3次,每次延迟5s,之后每次延迟翻倍*/
    @Retryable(retryFor = {RuntimeException.class}, maxAttempts = 4, backoff = @Backoff(delay = 2000L, multiplier = 2))
    public void send(String destination, Message<?> message) {
        rocketMQTemplate.send(destination, message);
    }

    @Retryable(retryFor = {RuntimeException.class}, maxAttempts = 4, backoff = @Backoff(delay = 2000L, multiplier = 2))
    public void asyncSend(String destination, Message<?> message, SendCallback sendCallback) {
        rocketMQTemplate.asyncSend(destination, message, sendCallback);
    }

    /**
     * 当重试次数达到限定时 , 会执行@Recover注解的补偿方法 , 只有在入参与发生异常匹配时才会执行该补偿方法
     */
    @Recover
    public void recover(RuntimeException e) {
        log.error("rocketmq重试失败", e);
    }
}
