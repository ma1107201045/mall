package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.biz.system.model.entity.LogDO;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.core.util.ServerResponse;
import feign.Request;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 19:55
 * @Description:
 */
@Slf4j
@Hidden
@RequiredArgsConstructor
@RestController
public class LogFeignProvider implements LogFeign {

    private final LogService logService;

    @Operation(summary = "保存", description = "保存")
    @Override
    public ServerResponse<Void> save(LogReqDTO logReqDTO, Request.Options options) {
        logService.create(logReqDTO, LogDO.class);
        return ServerResponse.success();
    }
}
