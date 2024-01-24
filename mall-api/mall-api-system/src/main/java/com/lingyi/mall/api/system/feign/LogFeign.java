package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.request.LogRequest;
import com.lingyi.mall.api.system.fallbackfactory.LogFeignFallbackFactory;
import com.lingyi.mall.common.web.util.ServerResponse;
import feign.Request;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 18:47
 * @Description:
 */
@Hidden
@Tag(name = "系统日志", description = "系统日志")
@FeignClient(value = "mall-web-admin-system", fallbackFactory = LogFeignFallbackFactory.class)
public interface LogFeign {

    String URL_PREFIX = "/provider/logs";

    /**
     * 保存
     *
     * @param logRequest logRequest
     * @param options    options
     * @return ServerResponse<Void>
     */
    @Operation(description = "保存")
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> save(@RequestBody LogRequest logRequest, Request.Options options);
}
