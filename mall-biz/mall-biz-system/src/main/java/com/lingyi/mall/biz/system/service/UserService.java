package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.biz.system.model.dto.UserDTO;
import com.lingyi.mall.biz.system.model.entity.UserDO;
import com.lingyi.mall.biz.system.model.query.RoleQuery;
import com.lingyi.mall.biz.system.model.query.UserQuery;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.biz.system.model.vo.UserVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:28
 * @description
 */
public interface UserService extends BaseServicePro<UserDTO, UserVO, UserQuery, UserDO, Long> {
    /**
     * 保存
     *
     * @param userDTO 。。
     */
    void create(UserDTO userDTO);


    /**
     * 读取角色集
     *
     * @param roleQuery ..
     * @return List<RoleVO>
     */
    List<RoleVO> readRoleList(RoleQuery roleQuery);

    /**
     * 更新部分信息
     *
     * @param userPartRequest ..
     */
    void updatePartById(UserPartRequest userPartRequest);


    /**
     * 按照用户名称查询用户信息以及菜单权限标识
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserResponse readUserAndMenuPermissionsByUserName(String userName);

    /**
     * 按照用户名称和菜单父级id查询菜单集
     *
     * @param userName 用户名称
     * @return List<MenuResDTO>
     */
    List<MenuResponse> readMenuTreesByUserName(String userName);

    /**
     * 按照用户id和用户名称查询权限
     *
     * @param userName 用户名称
     * @return List<String>
     */
    List<String> readMenuPermissionsByUserName(String userName);


}
