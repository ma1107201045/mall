package com.lingyi.mall.web.admin.sms.controller;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.sms.model.entity.LogDO;
import com.lingyi.mall.biz.sms.model.param.LogParam;
import com.lingyi.mall.biz.sms.model.vo.LogVO;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/17 15:17
 * @Description:
 */
@Tag(name = "短信日志", description = "短信日志")
@RestController
@RequestMapping("/sms-logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @Operation(summary = "删除/批量删除", description = "删除/批量删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:sms:logs:delete')")
    public ServerResponse<LogDO> deleteByIds(@PathVariable List<Long> ids) {
        logService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:sms:logs:get')")
    public ServerResponse<LogVO> getById(@PathVariable Long id) {
        var logVO = logService.readById(id);
        return ServerResponse.success(logVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:sms:logs:getList')")
    public ServerResponse<List<LogVO>> getListByPageAndParam(@Valid LogParam logParam) {
        var page = PageHelper.startPage(logParam.getCurrentPage(), logParam.getPageSize(), logParam.getSort());
        var logs = logService.readListByParam(logParam);
        return ServerResponse.success(logs, page.getTotal());
    }
}
