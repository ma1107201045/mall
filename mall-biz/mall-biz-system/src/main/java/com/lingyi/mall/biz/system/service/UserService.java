package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.UserDTO;
import com.lingyi.mall.api.system.dto.UserPartDTO;
import com.lingyi.mall.api.system.param.UserParam;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
import com.lingyi.mall.common.base.util.BaseService;


import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:28
 * @description
 */
public interface UserService extends BaseService<UserDTO, UserParam, UserVO, Long> {


    /**
     * 更新部分信息
     *
     * @param userPartDTO ..
     */
    void editPartById(UserPartDTO userPartDTO);


    /**
     * 按照用户名称查询用户信息以及菜单权限标识
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserVO findUserAndMenuPermissionsByUserName(String userName);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName     用户名称
     * @param menuParentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> findMenuTreeByUserNameAndMenuParentId(String userName, Long menuParentId);


}