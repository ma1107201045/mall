package com.lingyi.mall.web.admin.info.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.info.model.entity.InfoLogDO;
import com.lingyi.mall.biz.info.model.param.InfoLogQuery;
import com.lingyi.mall.biz.info.model.vo.InfoLogVO;
import com.lingyi.mall.biz.info.service.InfoLogService;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
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
@SaCheckLogin
@RequiredArgsConstructor
public class LogController {

    private final InfoLogService infoLogService;

    @Operation(summary = "删除/批量删除", description = "删除/批量删除")
    @DeleteMapping("/{ids}")
    @SaCheckPermission("admin:info:logs:delete")
    public ServerResponse<InfoLogDO> deleteByIds(@PathVariable List<Long> ids) {
        infoLogService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckPermission("admin:info:logs:get")
    public ServerResponse<InfoLogVO> getById(@PathVariable Long id) {
        var logVO = infoLogService.readById(id);
        return ServerResponse.success(logVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckPermission("admin:info:logs:getList")
    public ServerResponse<List<InfoLogVO>> getListByPageAndParam(@ParameterObject @Valid InfoLogQuery infoLogQuery) {
        var page = PageHelper.startPage(infoLogQuery.getCurrentPage(), infoLogQuery.getPageSize(), infoLogQuery.getSort());
        var logs = infoLogService.readListByParam(infoLogQuery);
        return ServerResponse.success(logs, page.getTotal());
    }
}
