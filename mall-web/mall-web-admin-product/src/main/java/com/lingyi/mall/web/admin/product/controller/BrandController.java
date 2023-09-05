package com.lingyi.mall.web.admin.product.controller;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.product.dto.BrandDTO;
import com.lingyi.mall.biz.product.param.BrandParam;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.biz.product.vo.BrandVO;
import com.lingyi.mall.common.base.enums.OperationTypeEnum;
import com.lingyi.mall.common.base.util.ServerResponse;
import com.lingyi.mall.common.security.common.aspetct.Log;
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
 * @DateTime: 2023/9/4 9:27
 * @Description:
 */
@Tag(name = "商品品牌", description = "商品品牌")
@RestController
@RequestMapping("/admin/system/users")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:brands:save')")
    @Log(title = "保存品牌", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody BrandDTO brandDTO) {
        brandService.create(brandDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:brands:delete')")
    @Log(title = "删除品牌", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        brandService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:brands:update')")
    @Log(title = "更新品牌", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody BrandDTO brandDTO) {
        brandDTO.setId(id);
        brandService.updateById(brandDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:brands:get')")
    @Log(title = "查询品牌", operationType = OperationTypeEnum.READ)
    public ServerResponse<BrandVO> getById(@PathVariable Long id) {
        var brandVO = brandService.readById(id);
        return ServerResponse.success(brandVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:brands:getList')")
    @Log(title = "查询品牌列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<BrandVO>> getListByPageAndParam(@Valid BrandParam brandParam) {
        var page = PageHelper.startPage(brandParam.getCurrentPage(), brandParam.getPageSize());
        var brands = brandService.readListByParam(brandParam);
        return ServerResponse.success(brands, page.getTotal());
    }

}