package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.param.MenuParam;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.common.jdbc.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
public interface MenuService extends BaseService<MenuDTO, MenuParam, MenuVO, Long> {

    /**
     * 通过父级id查询菜单树
     *
     * @return List<MenuVO>
     */
    List<MenuVO> readTree();



    /**
     * 按照菜单类型集和菜单上级id查询
     *
     * @param types 菜单类型集
     * @return List<MenuTreeVO>
     */
    List<MenuRespDTO> readListByTypes(List<Integer> types);
}
