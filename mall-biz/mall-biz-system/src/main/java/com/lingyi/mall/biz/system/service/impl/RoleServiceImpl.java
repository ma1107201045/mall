package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.biz.system.model.dto.RoleDTO;
import com.lingyi.mall.biz.system.model.entity.RoleDO;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.dao.mapper.RoleMapper;
import com.lingyi.mall.biz.system.model.param.RoleParam;
import com.lingyi.mall.biz.system.dao.repository.RoleRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.service.RoleMenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.biz.system.model.vo.MenuVO;
import com.lingyi.mall.biz.system.model.vo.RoleVO;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceProImpl<RoleRepository, RoleMapper, RoleDTO, RoleVO, RoleParam, RoleDO, Long>
        implements RoleService {

    private final RoleMenuService roleMenuService;

    private final MenuService menuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(RoleDTO roleDTO) {
        //保存
        Long id = create(roleDTO, RoleDO.class);
        //保存角色菜单信息
        roleMenuService.saveList(id, roleDTO.getMenuIds());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        super.deleteByIds(ids);
        roleMenuService.removeByRoleIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(RoleDTO roleDTO) {
        //获取id
        Long id = roleDTO.getId();
        //获取角色信息
        var optional = jpaRepository.findById(id);
        //判断用户是否不为空
        AssertUtil.isFalse(optional.isEmpty(), SystemFailEnum.ROLE_NULL_ERROR);
        //获取用户
        var roleDO = optional.get();
        //DTO转换Entity
        ConverterUtil.to(roleDTO, roleDO);
        //更新
        updateById(roleDO);
        //删除角色菜单集
        roleMenuService.removeByRoleIds(Collections.singletonList(id));
        //保存角色菜单信息
        roleMenuService.saveList(id, roleDTO.getMenuIds());
    }


    @Override
    public List<MenuVO> readMenuTree() {
        return menuService.readTree();
    }
}
