package com.lingyi.mall.web.member.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/31 9:07
 * @description
 */
@Tag(name = "【会员服务】", description = "【会员服务】")
@RequestMapping("/app/member/member")
@RestController
@RequiredArgsConstructor
public class MemberController {
    @Operation(summary = "hell", description = "hell")
    @GetMapping
    public String hello() {
        return "hello";
    }
}
