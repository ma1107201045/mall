package com.lingyi.mall.web.admin.product.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.product.model.dto.BrandDTO;
import com.lingyi.mall.biz.product.model.entity.BrandDO;
import com.lingyi.mall.biz.product.model.query.BrandQuery;
import com.lingyi.mall.biz.product.model.vo.BrandVO;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
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
 * @DateTime: 2023/9/4 9:27
 * @Description:
 */
@Tag(name = "商品品牌", description = "商品品牌")
@RestController
@RequestMapping("/brands")
@SaCheckLogin
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckPermission("admin:product:brands:save")
    public ServerResponse<Void> save(@Valid @RequestBody BrandDTO brandDTO) {
        brandService.create(brandDTO, BrandDO.class);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckPermission("admin:product:brands:delete")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        brandService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckPermission("admin:product:brands:update")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody BrandDTO brandDTO) {
        brandDTO.setId(id);
        brandService.updateById(brandDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckPermission("admin:product:brands:get")
    public ServerResponse<BrandVO> getById(@PathVariable Long id) {
        var brandVO = brandService.readById(id);
        return ServerResponse.success(brandVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckPermission("admin:product:brands:getList")
    public ServerResponse<List<BrandVO>> getListByPageAndParam(@ParameterObject @Valid BrandQuery brandQuery) {
        var page = PageHelper.startPage(brandQuery.getCurrentPage(), brandQuery.getPageSize());
        var brands = brandService.readListByParam(brandQuery);
        return ServerResponse.success(brands, page.getTotal());
    }

}
