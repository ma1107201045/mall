package com.lingyi.mall.auth.background.controller;

import com.lingyi.mall.auth.background.dto.UserDetailsDTO;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 用户详情controller
 */
@Tag(name = "用户认证", description = "登录、注销等接口")
@RestController
@RequestMapping("/user-details")
@RequiredArgsConstructor
public class UserDetailsController {

    @Operation(summary = "登录", description = "登录")
    @PostMapping
    public ServerResponse<Void> login(@Validated @RequestBody UserDetailsDTO userDetailsDTO) {
        return ServerResponse.success();
    }

    @Operation(summary = "注销", description = "注销")
    @DeleteMapping
    public ServerResponse<Void> logout() {
        return ServerResponse.success();
    }
}
