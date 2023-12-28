package com.lingyi.mall.biz.system.dao.mapper;

import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.biz.system.model.query.MenuQuery;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:58
 * @description
 */
@Mapper
public interface MenuMapper extends MybatisMapperImplementation<MenuVO, MenuQuery, Long> {

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
     * 按照类型集和父级id查询
     *
     * @param types 按钮类型集
     * @return List<MenuResDTO>
     */
    List<MenuResponse> selectListByTypes(List<Integer> types);

}
