package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.entity.Menu;
import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.common.bean.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
public interface MbsMenuService extends BaseService<Menu, Menu, Menu, Long> {

    /**
     * 通过父级id查询
     *
     * @param parentId 父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> findTreeByParentId(Long parentId);

    /**
     * 按照菜单类型查询
     *
     * @param type 按钮类型
     * @return List<String>
     */
    List<String> findPermissionsByType(Integer type);


    /**
     * 按照菜单类型集和菜单上级id查询
     *
     * @param types    菜单类型集
     * @param parentId 菜单父级id
     * @return List<MenuTreeVO>
     */
    List<MenuVO> findListByTypesAndParentId(List<Integer> types, Long parentId);
}
