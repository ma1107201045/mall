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
     * @param userId      用户id
     * @param userPartRequest 用户信息
     */
    void updateUserByUserId(Long userId, UserPartRequest userPartRequest);

    /**
     * 按照用户名称查询菜单树
     *
     * @param userName 用户名称
     * @return 菜单树
     */
    List<MenuResponse> readMenuTreesByUserName(String userName);


    /**
     * 按照用户名称查询菜单权限集
     *
     * @param userName 用户名称
     * @return 菜单权限集
     */
    List<String> readMenuPermissionsByUserName(String userName);


}
