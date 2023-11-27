package com.lingyi.mall.api.system.fallbackfactory;

import com.lingyi.mall.api.system.request.LogRequest;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.common.core.util.ServerResponse;
import feign.Request;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 18:47
 * @Description:
 */
public class LogFeignFallbackFactory implements FallbackFactory<LogFeign> {
    @Override
    public LogFeign create(Throwable cause) {
        return new LogFeign() {
            @Override
            public ServerResponse<Void> save(LogRequest logDTO, Request.Options options) {
                return null;
            }

        };
    }
}
