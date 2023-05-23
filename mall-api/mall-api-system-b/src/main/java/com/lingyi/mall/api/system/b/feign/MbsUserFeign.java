package com.lingyi.mall.api.system.b.feign;

import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.api.system.b.fallbackfactory.MbsUserFeignFallbackFactory;
import com.lingyi.mall.api.system.b.vo.UserVO;
import com.lingyi.mall.common.base.util.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:34
 * @Description:
 */
@FeignClient(url = "http://localhost:9002", value = "mall-biz-system", fallbackFactory = MbsUserFeignFallbackFactory.class)
public interface MbsUserFeign {

    /**
     * 按照用户名称查询用户信息和按钮权限标识
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/mbs/b/provider/users/permissions")
    ServerResponse<UserVO> getUserAndMenuPermissionsByUserName(@RequestParam(name = "userName") String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    @GetMapping("/mbs/b/provider/users/menu-tree")
    ServerResponse<List<MenuVO>> getMenuTreeByUserName(@RequestParam(name = "userName") String userName);
}