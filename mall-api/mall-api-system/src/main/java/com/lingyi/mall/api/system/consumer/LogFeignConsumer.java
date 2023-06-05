package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.entity.Log;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import com.lingyi.mall.common.base.util.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public void save(Log logEntity) {
        log.info("入参:log:{}", logEntity);
        ServerResponse<Void> response = logFeign.save(logEntity);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

}
