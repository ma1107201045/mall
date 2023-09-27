package com.lingyi.mall.web.admin.product.controller;

import com.lingyi.mall.biz.product.dto.CategoryDTO;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.biz.product.vo.CategoryVO;
import com.lingyi.mall.common.core.annotation.Log;
import com.lingyi.mall.common.core.enums.OperationTypeEnum;
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
 * @DateTime: 2023/9/5 9:12
 * @Description:
 */
@Tag(name = "分类", description = "分类")
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:save')")
    @Log(title = "保存分类", operationType = OperationTypeEnum.CREATE)
    public ServerResponse<Void> save(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:delete')")
    @Log(title = "删除分类", operationType = OperationTypeEnum.DELETE)
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        categoryService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:update')")
    @Log(title = "更新分类", operationType = OperationTypeEnum.UPDATE)
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        categoryService.updateById(categoryDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:get')")
    @Log(title = "查询分类", operationType = OperationTypeEnum.READ)
    public ServerResponse<CategoryVO> getById(@PathVariable Long id) {
        var categoryVO = categoryService.readById(id);
        return ServerResponse.success(categoryVO);
    }

    @Operation(summary = "查询树", description = "查询树")
    @GetMapping("/get-tree")
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:getTree')")
    @Log(title = "查询分类树", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<CategoryVO>> getTree() {
        var categories = categoryService.readTree();
        return ServerResponse.success(categories);
    }

    @Operation(summary = "查询属性值", description = "查询属性值")
    @GetMapping("/attributes")
    @PreAuthorize("@ps.hasAnyAuthority('admin:product:categories:attributes:getList')")
    @Log(title = "查询分类树", operationType = OperationTypeEnum.READ)
    public ServerResponse<List<AttributeVO>> getAttributesList() {
        var attributes = categoryService.readAttributeList();
        return ServerResponse.success(attributes);
    }

}
