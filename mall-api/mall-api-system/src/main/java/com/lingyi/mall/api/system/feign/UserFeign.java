package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.dto.MenuDTO;
import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.api.system.fallbackfactory.UserFeignFallbackFactory;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
@FeignClient(url = "http://localhost:7003", value = "mall-web-admin-system", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    String URL_PREFIX = "/admin/system/users";

    /**
     * 更新部分用户信息
     *
     * @param id          主键id
     * @param userPartDTO ..
     * @return ServerResponse
     */
    @PatchMapping(URL_PREFIX + "/{id}")
    ServerResponse<Void> updatePartById(@PathVariable("id") Long id, @RequestBody UserPartDTO userPartDTO);

    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX + "/permissions")
    ServerResponse<UserDTO> getUserAndMenuPermissionsByUserName(@RequestParam(name = "userName") String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping(URL_PREFIX + "/menu-tree")
    ServerResponse<List<MenuDTO>> getMenuTreeByUserName(@RequestParam(name = "userName") String userName);
}
