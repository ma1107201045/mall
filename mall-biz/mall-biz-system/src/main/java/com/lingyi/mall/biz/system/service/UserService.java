package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserResDTO;
import com.lingyi.mall.biz.system.dto.UserDTO;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.vo.UserVO;
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
     * 读取角色集
     *
     * @return List<RoleVO>
     */
    List<RoleVO> readRoleList();

    /**
     * 更新部分信息
     *
     * @param userPartDTO ..
     */
    void updatePartById(UserPartReqDTO userPartDTO);


    /**
     * 按照用户名称查询用户信息以及菜单权限标识
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserResDTO readUserAndMenuPermissionsByUserName(String userName);

    /**
     * 按照用户名称和菜单父级id查询菜单集
     *
     * @param userName     用户名称
     * @param menuParentId 菜单父级id
     * @return List<MenuResDTO>
     */
    List<MenuResDTO> readMenuListByUserNameAndMenuParentId(String userName, Long menuParentId);


    /**
     * 按照用户名称和菜单父级id查询菜单树
     *
     * @param userName     用户名称
     * @param menuParentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuResDTO> readMenuTreeByUserNameAndMenuParentId(String userName, Long menuParentId);


    /**
     * 按照用户名称查询菜单树
     *
     * @param userName     用户名称
     * @param menuParentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuResDTO> readMenuTreeByUserNameAndMenuParentIdv2(String userName, Long menuParentId);


    /**
     * 按照用户名称查询菜单树
     *
     * @param menuParentId   菜单父级id
     * @param menuResDTOList 菜单集
     * @return List<MenuTreeVO>
     */
    List<MenuResDTO> readMenuTreeByUserNameAndMenuParentIdv3(Long menuParentId, List<MenuResDTO> menuResDTOList);

    /**
     * 按照用户id和用户名称查询权限
     *
     * @param userId   用户id
     * @param userName 用户名称
     * @return List<String>
     */
    List<String> readMenuPermissionsByUserIdAndUserName(Long userId, String userName);

}
