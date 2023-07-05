package com.lingyi.mall.web.admin.system.controller;

import com.github.pagehelper.Page;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.param.LogParam;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.util.PageUtil;
import com.lingyi.mall.common.util.ServerResponse;
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
@Tag(name = "【系统管理服务-日志】", description = "【系统管理服务-日志】")
@RequestMapping("/admin/system/logs")
@RestController
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @Operation(summary = "删除/批量删除", description = "删除/批量删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:logs:delete')")
    public ServerResponse<LogDO> deleteByIds(@PathVariable List<Long> ids) {
        logService.deleteByIds(ids);
        return ServerResponse.success();
    }

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
    public ServerResponse<List<LogDO>> getListByPageAndParam(@Valid LogParam logParam) {
        Page<LogDO> page = PageUtil.startPage(logParam);
        List<LogDO> logs = logService.readListByParam(logParam);
        return ServerResponse.success(logs, page.getTotal());
    }

}
