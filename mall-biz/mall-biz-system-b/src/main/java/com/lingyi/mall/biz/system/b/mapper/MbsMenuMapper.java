package com.lingyi.mall.biz.system.b.mapper;

import com.lingyi.mall.api.system.b.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:58
 * @description
 */
@Mapper
public interface MbsMenuMapper {

    /**
     * 按照id查询菜单类型
     *
     * @param id id
     * @return Integer
     */
    Integer selectTypeById(Long id);

    /**
     * 按照id查询
     *
     * @param id id
     * @return MenuVO
     */
    MenuVO selectById(Long id);


    /**
     * 按照父级id查询
     *
     * @param parentId 父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> selectListByParentId(Long parentId);

    /**
     * 查询按钮权限标识集
     *
     * @param type 按钮类型
     * @return List<String>
     */
    List<String> selectPermissionByType(Integer type);


    /**
     * 按照类型集和父级id查询
     *
     * @param types    按钮类型集
     * @param parentId 父级菜单id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> selectListByTypesAndParentId(@Param("types") List<Integer> types, @Param("parentId") Long parentId);

}
