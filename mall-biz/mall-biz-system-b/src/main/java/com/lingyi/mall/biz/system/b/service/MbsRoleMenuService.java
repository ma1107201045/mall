package com.lingyi.mall.biz.system.b.service;

import com.lingyi.mall.api.system.b.dto.RoleMenuDTO;
import com.lingyi.mall.api.system.b.param.RoleMenuParma;
import com.lingyi.mall.api.system.b.vo.RoleMenuVO;
import com.lingyi.mall.common.bean.util.BaseService;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:30
 * @description
 */
public interface MbsRoleMenuService  {

    /**
     * 保存多条
     *
     * @param roleId  角色id
     * @param menuIds 菜单id集
     */
    void saveList(Long roleId, List<Long> menuIds);


    /**
     * 按照角色id删除角色菜单
     *
     * @param roleId 角色id
     */
    void removeByRoleId(Long roleId);
}
