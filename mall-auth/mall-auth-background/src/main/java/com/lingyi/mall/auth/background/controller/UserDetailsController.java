package com.lingyi.mall.auth.background.controller;

import com.lingyi.mall.auth.background.dto.UserDetailsDTO;
import com.lingyi.mall.common.util.ServerResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/1 17:53
 * @description 用户详情controller
 */
@Schema(name = "用户详情", description = "用户详情")
@RestController
@RequestMapping("/user-details")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @PostMapping
    public ServerResponse<Void> login(@Validated @RequestBody UserDetailsDTO userDetailsDTO) {
        return ServerResponse.success();
    }

}
