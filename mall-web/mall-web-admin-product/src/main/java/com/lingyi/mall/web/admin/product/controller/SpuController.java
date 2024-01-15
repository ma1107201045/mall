package com.lingyi.mall.web.admin.product.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.common.core.vo.PageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 16:52
 * @Description:
 */
@Tag(name = "SPU", description = "SPU")
@RestController
@RequestMapping("/spus")
@RequiredArgsConstructor
public class SpuController {

    private final SpuService spuService;

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckLogin
    @SaCheckPermission("admin:product:spus:delete")
    public void deleteByIds(@PathVariable List<Long> ids) {
        spuService.deleteByIds(ids);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckLogin
    @SaCheckPermission("admin:product:spus:getList")
    public PageVO<List<SpuVO>> getListByPageAndParam(@Valid SpuQuery spuParam) {
        var page = PageHelper.startPage(spuParam.getCurrentPage(), spuParam.getPageSize());
        var spus = spuService.readListByParam(spuParam);
        return PageVO.build(page.getTotal(), spus);
    }
}
