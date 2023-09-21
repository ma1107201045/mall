package com.lingyi.mall.web.admin.product.controller;

import com.lingyi.mall.biz.product.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 9:12
 * @Description:
 */
@Tag(name = "商品分类", description = "商品分类")
@RestController
@RequestMapping("/admin/product/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



}
