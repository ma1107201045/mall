package com.lingyi.mall.api.system.feign;

import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.fallbackfactory.UserFeignFallbackFactory;
import com.lingyi.mall.api.system.vo.UserVO;
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
@FeignClient(url = "http://localhost:7003", value = "mall-web-system-admin", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeign {

    @PatchMapping("/admin/system/provider/users/{id}")
    ServerResponse<Void> updateLastLoginDateTimeById(@PathVariable("id") Long id);


    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/admin/system/provider/users/permissions")
    ServerResponse<UserVO> getUserAndMenuPermissionsByUserName(@RequestParam(name = "userName") String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/admin/system/provider/users/menu-tree")
    ServerResponse<List<MenuVO>> getMenuTreeByUserName(@RequestParam(name = "userName") String userName);
}
