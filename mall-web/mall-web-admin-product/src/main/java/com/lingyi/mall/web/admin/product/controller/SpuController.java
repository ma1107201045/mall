package com.lingyi.mall.web.admin.product.controller;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.common.core.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.vo.PageVO;
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
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:spus:delete')")
    @Log(title = "删除SPU", operationType = OperationTypeEnum.DELETE)
    public void deleteByIds(@PathVariable List<Long> ids) {
        spuService.deleteByIds(ids);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:spus:getList')")
    @Log(title = "查询SPU列表", operationType = OperationTypeEnum.READ)
    public PageVO<List<SpuVO>> getListByPageAndParam(@Valid SpuQuery spuParam) {
        var page = PageHelper.startPage(spuParam.getCurrentPage(), spuParam.getPageSize());
        var spus = spuService.readListByParam(spuParam);
        return PageVO.build(page.getTotal(), spus);
    }
}
