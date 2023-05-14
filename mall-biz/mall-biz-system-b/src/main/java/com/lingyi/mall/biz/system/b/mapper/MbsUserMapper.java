package com.lingyi.mall.biz.system.b.mapper;

import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.param.UserParam;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.api.system.b.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:52
 * @description
 */
@Mapper
public interface MbsUserMapper {
    /**
     * 通过id查询
     *
     * @param id id
     * @return UserVO
     */
    UserVO selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param userParam 用户信息
     * @return List<UserVO>
     */
    List<UserVO> selectListByParam(UserParam userParam);


    /**
     * 按照用户名称查询id
     *
     * @param userName 用户名称
     * @return Long
     */
    Long selectIdByUserName(String userName);


    /**
     * 按照用户名称查询
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserVO selectByUserName(String userName);


    /**
     * 按照用户id菜单类型查询按钮权限标识
     *
     * @param userId   用户id
     * @param menuType 按钮类型
     * @return MenuVO
     */
    List<String> selectMenuPermissionsByUserIdAndMenuType(@Param("userId") Long userId, @Param("menuType") Integer menuType);


    /**
     * 按照用户id菜单类型集和菜单父级id查询菜单列表
     *
     * @param userName     用户名称
     * @param menuTypes    按钮类型集
     * @param menuParentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> selectMenusByUserNameAndMenuTypesAndMenuParentId(@Param("userName") String userName, @Param("menuTypes") List<Integer> menuTypes, @Param("menuParentId") Long menuParentId);


}
