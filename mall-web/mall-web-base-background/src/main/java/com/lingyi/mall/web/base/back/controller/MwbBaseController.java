package com.lingyi.mall.web.base.back.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:46
 * @description
 */
@Tag(name = "【系统基础服务】", description = "【系统基础服务】")
@RequestMapping("/mwb/back/base")
@RestController
@RequiredArgsConstructor
public class MwbBaseController {
}
