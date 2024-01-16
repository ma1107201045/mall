package com.lingyi.mall.biz.base.service;


import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:35
 * @Description:
 */
public interface BaseService {
    /**
     * 按照用户id更改用户信息
     *
     * @param userId          用户id
     * @param userPartRequest 用户信息
     */
    void updateUserByUserId(Long userId, UserPartRequest userPartRequest);

    /**
     * 按照用户id查询菜单树
     *
     * @param userId 用户id
     * @return 菜单树
     */
    List<MenuResponse> readMenuTreesByUserId(Long userId);

    /**
     * 按照用户id查询权限标识集
     *
     * @param userId 用户id
     * @return 权限标识集
     */
    List<String> readMenuPermissionsByUserId(Long userId);


}
