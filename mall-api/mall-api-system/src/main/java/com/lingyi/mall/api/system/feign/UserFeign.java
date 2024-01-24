package com.lingyi.mall.api.system.feign;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.fallbackfactory.UserFeignFallbackFactory;
import com.lingyi.mall.common.web.util.ServerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
@Tag(name = "provider-系统用户", description = "provider-系统日志")
@FeignClient(value = "mall-web-admin-system", fallbackFactory = UserFeignFallbackFactory.class)
@Validated
public interface UserFeign {

    String URL_PREFIX = "/provider/users";

    @Operation(summary = "更新用户部分信息", description = "更新用户部分信息")
    @PatchMapping(URL_PREFIX + "/{id}")
    ServerResponse<Void> updatePartById(@PathVariable("id") Long id, @RequestBody UserPartRequest userPartRequest);

    /**
     * 按照用户名称查询用户信息
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @Operation(summary = "查询用户信息", description = "查询用户信息")
    @GetMapping(URL_PREFIX)
    ServerResponse<UserResponse> getUserByUserName(@RequestParam(name = "userName", required = false) @NotBlank(message = "用户名不能为空") String userName);

    /**
     * 按照用户id查询菜单树
     *
     * @param id 用户id
     * @return 菜单树
     */
    @Operation(summary = "查询用户菜单树", description = "查询用户菜单树")
    @GetMapping(URL_PREFIX + "/menu-trees/{id}")
    ServerResponse<List<MenuResponse>> getMenuTreesById(@PathVariable("id") Long id);

    /**
     * 按照用户id查询按钮权限标识
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Operation(summary = "查询用户权限集", description = "查询用户权限集")
    @GetMapping(URL_PREFIX + "/menu-permissions/{id}")
    ServerResponse<List<String>> getMenuPermissionsById(@PathVariable("id") Long id);


}
