package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.api.system.fallbackfactory.LogFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/6/3 18:47
 * @Description:
 */
@FeignClient( value = "mall-web-admin-system", fallbackFactory = LogFeignFallbackFactory.class)
public interface LogFeign {

    String URL_PREFIX = "/admin/system/logs";

    /**
     * 保存
     *
     * @param logDTO  logDTO
     * @param options options
     * @return ServerResponse<Void>
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> save(@RequestBody LogReqDTO logDTO, Request.Options options);
}
