package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.param.MenuParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.common.base.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
public interface MenuService extends BaseService<MenuDTO, MenuParam, MenuVO, Long> {

    /**
     * 通过父级id查询
     *
     * @param parentId 父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> readTreeByParentId(Long parentId);


    /**
     * 按照菜单类型查询
     *
     * @param type 按钮类型
     * @return List<String>
     */
    List<String> readPermissionsByType(Integer type);


    /**
     * 按照菜单类型集和菜单上级id查询
     *
     * @param parentId 菜单父级id
     * @param types    菜单类型集
     * @return List<MenuTreeVO>
     */
    List<MenuResDTO> readListByParentIdAndTypes(Long parentId, List<Integer> types);
}
