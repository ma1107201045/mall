package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.biz.system.entity.RoleMenuDO;
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
    public void createList(Long roleId, List<Long> menuIds) {
        var roleMenuDOList = menuIds.stream()
                .map(menuId -> RoleMenuDO.of(roleId, menuId))
                .toList();
        roleMenuRepository.saveAll(roleMenuDOList);
    }

    @Override
    public void deleteByRoleIds(List<Long> roleIds) {
        roleMenuRepository.deleteByRoleIds(roleIds);
    }
}
