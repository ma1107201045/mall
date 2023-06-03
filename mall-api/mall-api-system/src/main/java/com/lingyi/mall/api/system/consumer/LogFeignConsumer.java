package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.entity.Log;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import com.lingyi.mall.common.base.util.ServerResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 18:50
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class LogFeignConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogFeignConsumer.class);

    private final LogFeign logFeign;

    public void save(Log log) {
        LOGGER.info("入参:log:{}", log);
        ServerResponse<Void> response = logFeign.save(log);
        if (response.getIsSuccess()) {
            LOGGER.info("出参:Void:{}", JSON.toJSONString(response.getData()));
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

}
