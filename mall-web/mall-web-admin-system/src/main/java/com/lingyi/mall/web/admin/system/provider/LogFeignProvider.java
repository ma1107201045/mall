package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.entity.LogDO;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 19:55
 * @Description:
 */
@Tag(name = "后台【系统管理服务-日志-Provider】", description = "后台【系统管理服务-日志-Provider】")
@RequiredArgsConstructor
@RestController
public class LogFeignProvider implements LogFeign {

    private final LogService logService;

    @Operation(summary = "添加", description = "添加")
    @Override
    public ServerResponse<Void> save(LogDO logDO) {
        logService.create(logDO);
        return ServerResponse.success();
    }
}
