package com.lingyi.mall.web.admin.system.provider;

import com.lingyi.mall.api.system.request.LogRequest;
import com.lingyi.mall.api.system.feign.LogFeign;
import com.lingyi.mall.biz.system.model.entity.LogDO;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.web.util.ServerResponse;
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
@RestController
@RequiredArgsConstructor
public class LogFeignProvider implements LogFeign {

    private final LogService logService;

    @Override
    public ServerResponse<Void> save(LogRequest logRequest, Request.Options options) {
        logService.create(logRequest, LogDO.class);
        return ServerResponse.success();
    }
}
