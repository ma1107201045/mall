package com.lingyi.mall.web.app.info.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/25 9:49
 * @Description:
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "${rocketmq.pullConsumer.group}", topic = RocketMqTopicConstant.INFO_MESSAGE)
public class RocketMqListenerTest implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("收到消息啦{}", s);
    }
}
