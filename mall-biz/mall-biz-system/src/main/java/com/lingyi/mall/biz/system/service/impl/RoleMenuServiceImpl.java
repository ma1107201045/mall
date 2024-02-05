package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.biz.system.converter.RoleMenuConverter;
import com.lingyi.mall.biz.system.dao.repository.RoleMenuRepository;
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
        var roleMenus = RoleMenuConverter.INSTANCE.toRoleMenuDOList(roleId, menuIds);
        roleMenuRepository.saveAll(roleMenus);
    }

    @Override
    public void removeByRoleIds(List<Long> roleIds) {
        roleMenuRepository.deleteByRoleIds(roleIds);
    }
}
