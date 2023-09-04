package com.lingyi.mall.web.admin.product.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
