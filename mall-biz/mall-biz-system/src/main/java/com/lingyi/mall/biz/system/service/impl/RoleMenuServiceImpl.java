package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.entity.RoleMenu;
import com.lingyi.mall.biz.system.repository.RoleMenuRepository;
import com.lingyi.mall.biz.system.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:30
 * @description
 */
@Service
@RequiredArgsConstructor
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuRepository roleMenuRepository;


    @Override
    public void saveList(Long roleId, List<Long> menuIds) {
        List<RoleMenu> roleMenus = menuIds.stream()
                .map(menuId -> RoleMenu.of(roleId, menuId))
                .toList();
        roleMenuRepository.saveAll(roleMenus);
    }

    @Override
    public void removeByRoleId(Long roleId) {
        roleMenuRepository.deleteByRoleId(roleId);
    }
}
