package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.vo.MenuVO;
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
     * 按照类型查询
     *
     * @param type 按钮类型
     * @return List<MbsMenuVO>
     */
    List<MenuVO> selectListByType(Integer type);

    /**
     * 按照用户名称和菜单类型查询
     *
     * @param type   按钮类型
     * @param userId 用户id
     * @return List<MbsMenuVO>
     */
    List<MenuVO> selectListByTypeAndUserId(@Param("type") Integer type, @Param("userId") Long userId);
}
