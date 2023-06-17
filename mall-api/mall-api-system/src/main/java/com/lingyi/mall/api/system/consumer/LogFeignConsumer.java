package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.util.OpenFeignException;
import com.lingyi.mall.common.util.ServerResponse;
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

    public void save(LogReqDTO logDTO) {
        log.info("入参:log:{}", logDTO);
        ServerResponse<Void> response = logFeign.save(logDTO, new Request.Options(5L, TimeUnit.SECONDS, 4L, TimeUnit.SECONDS, true));
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

}
