package com.lingyi.mall.web.admin.product.controller;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
import com.lingyi.mall.common.core.util.ServerResponse;
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
 * @DateTime: 2023/9/4 16:17
 * @Description:
 */
@Tag(name = "商品属性", description = "商品属性")
@RestController
@RequestMapping("/admin/product/attributes")
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:attributes:save')")
    @Log(title = "保存属性", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody AttributeDTO attributeDTO) {
        attributeService.create(attributeDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:attributes:delete')")
    @Log(title = "删除属性", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        attributeService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:attributes:update')")
    @Log(title = "更新属性", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody AttributeDTO attributeDTO) {
        attributeDTO.setId(id);
        attributeService.updateById(attributeDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:attributes:get')")
    @Log(title = "查询属性", operationType = OperationTypeEnum.READ)
    public ServerResponse<AttributeVO> getById(@PathVariable Long id) {
        var attributeVO = attributeService.readById(id);
        return ServerResponse.success(attributeVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:system:attributes:getList')")
    @Log(title = "查询属性列表", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<AttributeVO>> getListByPageAndParam(@Valid AttributeParam attributeParam) {
        var total = attributeService.countByParam(attributeParam);
        var attributes = attributeService.readListByParam(attributeParam);
        return ServerResponse.success(attributes, total);
    }
}
