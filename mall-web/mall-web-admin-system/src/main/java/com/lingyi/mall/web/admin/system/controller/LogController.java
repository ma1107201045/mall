package com.lingyi.mall.web.admin.system.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.system.model.query.LogQuery;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.biz.system.model.vo.LogVO;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:43
 * @description
 */
@Tag(name = "系统日志", description = "系统日志")
@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
@SentinelResource
public class LogController {

    private final LogService logService;

    @Operation(summary = "删除/批量删除", description = "删除/批量删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:delete')")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        logService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:get')")
    public ServerResponse<LogVO> getById(@PathVariable Long id) {
        var logVO = logService.readById(id);
        return ServerResponse.success(logVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:getList')")
    public ServerResponse<List<LogVO>> getListByPageAndParam(@Valid LogQuery logQuery) {
        var page = PageHelper.startPage(logQuery.getCurrentPage(), logQuery.getPageSize(), logQuery.getSort());
        var logs = logService.readListByParam(logQuery);
        return ServerResponse.success(logs, page.getTotal());
    }

}
