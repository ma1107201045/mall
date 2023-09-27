package com.lingyi.mall.web.admin.product.controller;

import com.lingyi.mall.biz.product.service.SpuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/5 16:52
 * @Description:
 */
@Tag(name = "SPU", description = "SPU")
@RestController
@RequestMapping("/admin/product/spus")
@RequiredArgsConstructor
public class SpuController {

    private final SpuService spuService;
}
