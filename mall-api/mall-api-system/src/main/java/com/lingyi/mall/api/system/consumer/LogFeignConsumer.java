package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.entity.LogDO;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.base.exception.OpenFeignException;
import com.lingyi.mall.common.base.util.ServerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public void save(LogDO logDO) {
        log.info("入参:log:{}", logDO);
        ServerResponse<Void> response = logFeign.save(logDO);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }

}
