package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.request.LogRequest;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import feign.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 18:50
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LogFeignConsumer {

    private final LogFeign logFeign;

    public void save(LogRequest logRequest) {
        log.info("入参:log:{}", logRequest);
        var response = logFeign.save(logRequest, new Request.Options(20L, TimeUnit.SECONDS, 20L, TimeUnit.SECONDS, true));
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

}
