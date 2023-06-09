package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.dto.LogDTO;
import com.lingyi.mall.api.system.fallbackfactory.LogFeignFallbackFactory;
import com.lingyi.mall.common.base.util.ServerResponse;
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
@FeignClient(url = "http://localhost:7003", value = "mall-web-admin-system", fallbackFactory = LogFeignFallbackFactory.class)
public interface LogFeign {

    String URL_PREFIX = "/admin/system/logs";

    /**
     * 保存
     *
     * @param logDTO 。。
     * @return ServerResponse
     */
    @PostMapping(URL_PREFIX)
    ServerResponse<Void> save(@RequestBody LogDTO logDTO, Request.Options options);
}
