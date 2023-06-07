package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.entity.LogDO;
import com.lingyi.mall.api.system.fallbackfactory.LogFeignFallbackFactory;
import com.lingyi.mall.common.base.util.ServerResponse;
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

    /**
     * 保存
     *
     * @param logDO 。。
     * @return ServerResponse
     */
    @PostMapping("/admin/system/logs")
    ServerResponse<Void> save(@RequestBody LogDO logDO);
}
