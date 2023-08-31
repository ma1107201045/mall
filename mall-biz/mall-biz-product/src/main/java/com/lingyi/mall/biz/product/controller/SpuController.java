package com.lingyi.mall.biz.product.controller;

import com.lingyi.mall.biz.product.service.SpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:37
 * @Description:
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class SpuController {

    private final SpuService spuService;
}
