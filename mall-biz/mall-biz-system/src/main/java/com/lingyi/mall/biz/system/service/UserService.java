package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.biz.system.dto.UserDTO;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.orm.util.BaseService;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:28
 * @description
 */
public interface UserService extends BaseService<UserDTO, UserParam, UserVO, Long> {

    /**
     * 按照参数统计数量
     *
     * @param userParam 参数
     * @return 数量
     */
    Long countByParam(UserParam userParam);

    /**
     * 读取角色集
     *
     * @param basePageParam ..
     * @return List<RoleVO>
     */
    List<RoleVO> readRoleList(BasePageParam basePageParam);

    /**
     * 更新部分信息
     *
     * @param userPartReqDTO ..
     */
    void updatePartById(UserPartReqDTO userPartReqDTO);


    /**
     * 按照用户名称查询用户信息以及菜单权限标识
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserRespDTO readUserAndMenuPermissionsByUserName(String userName);

    /**
     * 按照用户名称和菜单父级id查询菜单集
     *
     * @param userName 用户名称
     * @return List<MenuResDTO>
     */
    List<MenuRespDTO> readMenuTreesByUserName(String userName);

    /**
     * 按照用户id和用户名称查询权限
     *
     * @param userName 用户名称
     * @return List<String>
     */
    List<String> readMenuPermissionsByUserName(String userName);


}
