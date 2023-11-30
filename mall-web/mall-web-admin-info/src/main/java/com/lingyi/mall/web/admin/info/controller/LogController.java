package com.lingyi.mall.web.admin.info.controller;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.info.model.entity.InfoLogDO;
import com.lingyi.mall.biz.info.model.param.InfoLogParam;
import com.lingyi.mall.biz.info.model.vo.InfoLogVO;
import com.lingyi.mall.biz.info.service.InfoLogService;
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
@RequestMapping("/info-logs")
@RequiredArgsConstructor
public class LogController {

    private final InfoLogService infoLogService;

    @Operation(summary = "删除/批量删除", description = "删除/批量删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:info:logs:delete')")
    public ServerResponse<InfoLogDO> deleteByIds(@PathVariable List<Long> ids) {
        infoLogService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:info:logs:get')")
    public ServerResponse<InfoLogVO> getById(@PathVariable Long id) {
        var logVO = infoLogService.readById(id);
        return ServerResponse.success(logVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:info:logs:getList')")
    public ServerResponse<List<InfoLogVO>> getListByPageAndParam(@Valid InfoLogParam infoLogParam) {
        var page = PageHelper.startPage(infoLogParam.getCurrentPage(), infoLogParam.getPageSize(), infoLogParam.getSort());
        var logs = infoLogService.readListByParam(infoLogParam);
        return ServerResponse.success(logs, page.getTotal());
    }
}
