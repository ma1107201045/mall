package com.lingyi.mall.web.app.info.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/24 15:38
 * @Description:
 */
@Tag(name = "信息服务", description = "信息服务")
@RestController
@RequestMapping("/infos")
@RequiredArgsConstructor
public class InfoController {

    @Operation(summary = "hell", description = "hell")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
