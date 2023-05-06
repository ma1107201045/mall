package com.lingyi.mall.auth.background.controller;

import com.lingyi.mall.auth.background.dto.UserAuthDTO;
import com.lingyi.mall.auth.background.service.UserService;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpCookie;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 用户认证controller
 */
@Tag(name = "用户认证", description = "登录、注销等接口")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "登录", description = "登录")
    @PostMapping("/login")
    public ServerResponse<Void> login(@Validated @RequestBody UserAuthDTO userAuthDTO) throws ServletException, IOException {
        userService.login(userAuthDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "注销", description = "注销")
    @DeleteMapping("/logout")
    public ServerResponse<Void> logout(HttpSession session) {
        userService.logout(session);
        return ServerResponse.success();
    }

    @Operation(summary = "测试", description = "测试")
    @GetMapping("/test")
    public ServerResponse<Void> test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ServerResponse.success();
    }
}
