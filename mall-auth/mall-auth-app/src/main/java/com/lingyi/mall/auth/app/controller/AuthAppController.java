package com.lingyi.mall.auth.app.controller;

import com.lingyi.mall.auth.app.dto.AuthAppLoginDTO;
import com.lingyi.mall.auth.app.dto.AuthAppSendDTO;
import com.lingyi.mall.auth.app.service.AuthAppService;
import com.lingyi.mall.auth.app.vo.AuthAppLoginVO;
import com.lingyi.mall.common.core.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:25
 * @description
 */
@Tag(name = "认证", description = "认证")
@Validated
@RestController
@RequestMapping("/auth/app")
@RequiredArgsConstructor
public class AuthAppController {

    private final AuthAppService authAppService;

    @Operation(summary = "发送短信验证码", description = "发送短信验证码")
    @PostMapping("/send")
    public ServerResponse<Void> send(AuthAppSendDTO authAppSendDTO) {
        authAppService.send(authAppSendDTO);
        return ServerResponse.success();
    }

    @Operation(summary = "手机号登录", description = "手机号登录")
    @PostMapping("/login")
    public ServerResponse<AuthAppLoginVO> login(@Valid @RequestBody AuthAppLoginDTO authAppLoginDTO) {
        var authAppLoginVO = authAppService.login(authAppLoginDTO);
        return ServerResponse.success(authAppLoginVO);
    }


    @Operation(summary = "注销", description = "注销")
    @PostMapping("/logout")
    public ServerResponse<AuthAppLoginVO> logout() {
        authAppService.logout();
        return ServerResponse.success();
    }

}
