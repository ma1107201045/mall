package com.lingyi.mall.biz.base.service;

import com.lingyi.mall.api.system.b.vo.MenuVO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:35
 * @Description:
 */
public interface MbbService {


    /**
     * 按照用户id查询菜单树
     *
     * @param userName 用户名称
     * @return 菜单树
     */
    List<MenuVO> findMenuTreeByUserId(String userName);

    /**
     * 按照用户id更改用户信息
     *
     * @param userId 用户id
     */
    void editUserByUserId(Long userId);
}
