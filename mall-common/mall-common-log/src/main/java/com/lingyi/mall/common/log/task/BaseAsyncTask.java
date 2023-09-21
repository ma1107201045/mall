package com.lingyi.mall.common.log.task;

import com.lingyi.mall.api.system.consumer.LogFeignConsumer;
import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.common.core.constant.BaseConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 20:38
 * @Description:
 */

@Slf4j
@RequiredArgsConstructor
@Component
@EnableAsync
public class BaseAsyncTask {

    private final LogFeignConsumer logFeignConsumer;

    @Async
    public void saveLog(LogReqDTO logDTO) {
        MDC.put(BaseConstant.TRACK_ID_NAME, logDTO.getTrackId());
        log.info("save log begin");
        logFeignConsumer.save(logDTO);
        log.info("save log end");
        MDC.remove(BaseConstant.TRACK_ID_NAME);
    }
}
