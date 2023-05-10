package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.util.BaseService;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:28
 * @description
 */
public interface MbsUserService extends BaseService<User, Long> {


    /**
     * 按照用户名称查询用户信息以及权限标识
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserVO findUserAndPermissionsByUserName(String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName     用户名称
     * @param menuParentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> findMenuTreeUserNameAndMenuParentId(String userName, Long menuParentId);


}
