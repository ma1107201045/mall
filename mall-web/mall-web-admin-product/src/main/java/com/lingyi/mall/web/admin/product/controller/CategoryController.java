package com.lingyi.mall.web.admin.product.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.lingyi.mall.biz.product.model.dto.CategoryDTO;
import com.lingyi.mall.biz.product.service.CategoryService;
import com.lingyi.mall.biz.product.model.vo.AttributeVO;
import com.lingyi.mall.biz.product.model.vo.CategoryVO;
import com.lingyi.mall.common.log.aspetct.annotation.Log;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 9:12
 * @Description:
 */
@Tag(name = "商品分类", description = "商品分类")
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "保存", description = "保存")
    @PostMapping
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:save")
    public ServerResponse<Void> save(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/{ids}")
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:delete")
    public ServerResponse<Void> deleteByIds(@PathVariable List<Long> ids) {
        categoryService.deleteByIds(ids);
        return ServerResponse.success();
    }

    @Operation(summary = "更新", description = "更新")
    @PutMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:update")
    public ServerResponse<Void> updateById(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        categoryService.updateById(categoryDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "查询", description = "查询")
    @GetMapping("/{id}")
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:get")
    public ServerResponse<CategoryVO> getById(@PathVariable Long id) {
        var categoryVO = categoryService.readById(id);
        return ServerResponse.success(categoryVO);
    }

    @Operation(summary = "查询树", description = "查询树")
    @GetMapping("/get-tree")
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:getTree")
    public ServerResponse<List<CategoryVO>> getTree() {
        var categories = categoryService.readTree();
        return ServerResponse.success(categories);
    }

    @Operation(summary = "查询属性值", description = "查询属性值")
    @GetMapping("/attributes")
    @SaCheckLogin
    @SaCheckPermission("admin:product:categories:getList")
    public ServerResponse<List<AttributeVO>> getAttributesList() {
        var attributes = categoryService.readAttributeList();
        return ServerResponse.success(attributes);
    }

}
