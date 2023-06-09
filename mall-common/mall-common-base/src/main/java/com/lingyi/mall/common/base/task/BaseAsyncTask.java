package com.lingyi.mall.common.base.task;

import com.lingyi.mall.api.system.consumer.LogFeignConsumer;
import com.lingyi.mall.api.system.dto.LogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 20:38
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class BaseAsyncTask {

    private final LogFeignConsumer logFeignConsumer;

    @Async
    public void saveLog(LogDTO logDTO) {
        logFeignConsumer.save(logDTO);
    }
}
