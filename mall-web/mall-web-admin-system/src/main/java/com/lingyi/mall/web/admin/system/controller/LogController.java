package com.lingyi.mall.web.admin.system.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.aspect.Log;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.PageUtil;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:43
 * @description
 */
@Tag(name = "【系统管理服务-日志】", description = "【系统管理服务-日志】")
@RequestMapping("/admin/system/logs")
@RestController
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:get')")
    public ServerResponse<LogDO> getById(@PathVariable Long id) {
        LogDO log = logService.readById(id);
        return ServerResponse.success(log);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:getList')")
    public ServerResponse<List<LogDO>> getListByPageAndParam(@Valid BasePageParam basePageParam, @Valid LogDO logDO) {
        Page<LogDO> page = PageUtil.startPage(basePageParam);
        List<LogDO> logs = logService.readListByParam(logDO);
        return ServerResponse.success(logs, page.getTotal());
    }

}
