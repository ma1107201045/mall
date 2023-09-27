package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.fallbackfactory.UserFeignFallbackFactory;
import com.lingyi.mall.common.core.util.ServerResponse;
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

    String URL_PREFIX = "/users";

    /**
     * 更新部分用户信息
     *
     * @param id          主键id
     * @param userPartDTO ..
     * @return ServerResponse
     */
    @PatchMapping(URL_PREFIX + "/{id}")
    ServerResponse<Void> updatePartById(@PathVariable("id") Long id, @RequestBody UserPartReqDTO userPartDTO);

    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX + "/permissions")
    ServerResponse<UserRespDTO> getUserAndMenuPermissionsByUserName(@RequestParam(name = "userName") String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName 用户名称
     * @return 菜单树
     */
    @GetMapping(URL_PREFIX + "/menu-trees")
    ServerResponse<List<MenuRespDTO>> getMenuTreesByUserName(@RequestParam(name = "userName") String userName);


    /**
     * 按照用户id和用户名称查询权限集
     *
     * @param userName 用户名称
     * @return 权限标识集
     */
    @GetMapping(URL_PREFIX + "/menu-permissions")
    ServerResponse<List<String>> getMenuPermissionsByUserName(@RequestParam(name = "userName") String userName);
}
