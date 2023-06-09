package com.lingyi.mall.common.base.task;

import com.lingyi.mall.api.system.consumer.LogFeignConsumer;
import com.lingyi.mall.api.system.dto.LogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * TODO 待优化（由于maven存在循环依赖，暂且只能通过反射调用类）
 *
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
