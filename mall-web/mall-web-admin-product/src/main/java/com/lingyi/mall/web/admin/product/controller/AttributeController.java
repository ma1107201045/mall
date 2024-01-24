package com.lingyi.mall.web.admin.product.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lingyi.mall.biz.product.model.dto.AttributeDTO;
import com.lingyi.mall.biz.product.model.query.AttributeQuery;
import com.lingyi.mall.biz.product.model.vo.AttributeVO;
import com.lingyi.mall.biz.product.service.AttributeService;
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
 * @DateTime: 2023/9/4 16:17
 * @Description:
 */
@Tag(name = "商品属性", description = "商品属性")
@RestController
@RequestMapping("/attributes")
@SaCheckLogin
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckPermission("admin:product:attributes:save")
    public ServerResponse<Void> save(@Valid @RequestBody AttributeDTO attributeDTO) {
        attributeService.create(attributeDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckPermission("admin:product:attributes:delete")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        attributeService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckPermission("admin:product:attributes:update")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody AttributeDTO attributeDTO) {
        attributeDTO.setId(id);
        attributeService.updateById(attributeDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckPermission("admin:product:attributes:get")
    public ServerResponse<AttributeVO> getById(@PathVariable Long id) {
        var attributeVO = attributeService.readById(id);
        return ServerResponse.success(attributeVO);
    }

    @Operation(summary = "查询列表", description = "查询列表")
    @GetMapping
    @SaCheckPermission("admin:product:attributes:getList")
    public ServerResponse<List<AttributeVO>> getListByPageAndParam(@ParameterObject @Valid AttributeQuery attributeParam) {
        var total = attributeService.totalByParam(attributeParam);
        var attributes = attributeService.readListByParam(attributeParam);
        return ServerResponse.success(attributes, total);
    }
}
