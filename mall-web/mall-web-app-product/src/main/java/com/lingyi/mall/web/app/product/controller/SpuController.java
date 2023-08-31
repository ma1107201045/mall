package com.lingyi.mall.web.app.product.controller;

import com.lingyi.mall.biz.product.service.SpuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:37
 * @Description:
 */
@Tag(name = "商品服务", description = "商品服务")
@RestController("/app/product/spus")
@RequestMapping
@RequiredArgsConstructor
public class SpuController {

    private final SpuService spuService;
}
