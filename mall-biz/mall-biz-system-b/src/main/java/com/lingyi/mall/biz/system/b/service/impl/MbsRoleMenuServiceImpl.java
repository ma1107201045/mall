package com.lingyi.mall.biz.system.b.service.impl;

import com.lingyi.mall.api.system.b.entity.RoleMenu;
import com.lingyi.mall.biz.system.b.mapper.MbsRoleMenuMapper;
import com.lingyi.mall.biz.system.b.repository.MbsRoleMenuRepository;
import com.lingyi.mall.biz.system.b.service.MbsRoleMenuService;
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
public class MbsRoleMenuServiceImpl implements MbsRoleMenuService {

    private final MbsRoleMenuRepository mbsRoleMenuRepository;


    @Override
    public void saveList(Long roleId, List<Long> menuIds) {
        List<RoleMenu> roleMenus = menuIds.stream()
                .map(menuId -> RoleMenu.of(roleId, menuId))
                .toList();
        mbsRoleMenuRepository.saveAll(roleMenus);
    }

    @Override
    public void removeByRoleId(Long roleId) {
        mbsRoleMenuRepository.deleteByRoleId(roleId);
    }
}
