package com.lingyi.mall.biz.system.converter;

import com.lingyi.mall.biz.system.entity.*;
import com.lingyi.mall.biz.system.model.entity.MenuDO;
import com.lingyi.mall.biz.system.model.entity.RoleDO;
import com.lingyi.mall.biz.system.model.entity.RoleMenuDO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/7 16:54
 * @Description:
 */
public final class RoleMenuConverter {

    public static final RoleMenuConverter INSTANCE = new RoleMenuConverter();

    private RoleMenuConverter() {

    }

    public RoleMenuDO of(Long roleId, Long menuId) {
        RoleDO roleDO = new RoleDO();
        roleDO.setId(roleId);
        MenuDO menuDO = new MenuDO();
        menuDO.setId(menuId);
        RoleMenuDO roleMenuDO = new RoleMenuDO();
        roleMenuDO.setRoleDO(roleDO);
        roleMenuDO.setMenuDO(menuDO);
        return roleMenuDO;
    }

    public List<RoleMenuDO> of(Long roleId, List<Long> menuIds) {
        return menuIds.stream()
                .map(menuId -> of(roleId, menuId))
                .toList();
    }
}
