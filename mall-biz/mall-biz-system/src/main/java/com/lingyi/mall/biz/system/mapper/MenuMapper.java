package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.biz.system.param.MenuParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
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
public interface MenuMapper {


    /**
     * 按照id查询
     *
     * @param id id
     * @return MenuVO
     */
    MenuVO selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param menuParam 菜单信息
     * @return List<MenuVO>
     */
    List<MenuVO> selectListByParam(MenuParam menuParam);


    /**
     * 按照父级id查询
     *
     * @param parentId 父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> selectListByParentId(Long parentId);


    /**
     * 按照id查询菜单类型
     *
     * @param id id
     * @return Integer
     */
    Integer selectTypeById(Long id);

    /**
     * 按照父级id查询id集合
     *
     * @param parentIds 父级id集
     * @return List<Long>
     */
    List<Long> selectIdsByParentIds(List<Long> parentIds);

    /**
     * 查询按钮权限标识集
     *
     * @param type 按钮类型
     * @return List<String>
     */
    List<String> selectPermissionsByType(Integer type);


    /**
     * 按照类型集和父级id查询
     *
     * @param parentId 父级id
     * @param types    按钮类型集
     * @return List<MenuTreeVO>
     */
    List<MenuResDTO> selectListByParentIdAndTypes(@Param("parentId") Long parentId, @Param("types") List<Integer> types);

}
