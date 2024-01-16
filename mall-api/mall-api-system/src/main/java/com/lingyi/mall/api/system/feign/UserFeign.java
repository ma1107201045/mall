package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.fallbackfactory.UserFeignFallbackFactory;
import com.lingyi.mall.common.web.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
@FeignClient(value = "mall-web-admin-system", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    String URL_PREFIX = "/provider/users";

    @PatchMapping(URL_PREFIX + "/{id}")
    ServerResponse<Void> updatePartById(@PathVariable("id") Long id, @RequestBody UserPartRequest userPartRequest);

    /**
     * 按照用户名称查询用户信息
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX)
    ServerResponse<UserResponse> getUserByUserName(@RequestParam(name = "userName") String userName);

    /**
     * 按照用户id查询菜单树
     *
     * @param id 用户id
     * @return 菜单树
     */
    @GetMapping(URL_PREFIX + "/menu-trees/{id}")
    ServerResponse<List<MenuResponse>> getMenuTreesById(@PathVariable("id") Long id);

    /**
     * 按照用户id查询按钮权限标识
     *
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX + "/menu-permissions/{id}")
    ServerResponse<List<String>> getMenuPermissionsById(@PathVariable Long id);


}
