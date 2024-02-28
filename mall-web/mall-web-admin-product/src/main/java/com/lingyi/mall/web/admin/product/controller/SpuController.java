package com.lingyi.mall.web.admin.product.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.common.core.vo.PageVO;
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
 * @DateTime: 2023/9/5 16:52
 * @Description:
 */
@Tag(name = "SPU", description = "SPU")
@RestController
@RequestMapping("/spus")
@SaCheckLogin
@RequiredArgsConstructor
public class SpuController {

    private final SpuService spuService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckPermission("admin:product:spus:save")
    public void save(@Valid @RequestBody SpuDTO spuDTO) {
        spuService.add(spuDTO);
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckPermission("admin:product:spus:delete")
    public void deleteByIds(@PathVariable List<Long> ids) {
        spuService.removeByIds(ids);
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckPermission("admin:product:spus:update")
    public void updateById(@PathVariable Long id, @Valid @RequestBody SpuDTO spuDTO) {
        spuDTO.setId(id);
        spuService.editById(spuDTO);
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckPermission("admin:system:spus:get")
    public ServerResponse<SpuVO> getById(@PathVariable Long id) {
        var userVO = spuService.getById(id);
        return ServerResponse.success(userVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckPermission("admin:product:spus:getList")
    public ServerResponse<PageVO<List<SpuVO>>> getListByPageAndParam(@ParameterObject @Valid SpuQuery spuQuery) {
        var page = PageHelper.startPage(spuQuery.getCurrentPage(), spuQuery.getPageSize());
        var spus = spuService.getListByQuery(spuQuery);
        return ServerResponse.success(PageVO.build(page.getTotal(), spus));
    }
}
