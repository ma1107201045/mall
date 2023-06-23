package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.dto.RoleDTO;
import com.lingyi.mall.biz.system.entity.RoleDO;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.param.RoleParam;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.vo.RoleVO;
import com.lingyi.mall.biz.system.mapper.RoleMapper;
import com.lingyi.mall.biz.system.repository.RoleRepository;
import com.lingyi.mall.biz.system.service.RoleMenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    private final RoleMenuService roleMenuService;

    private final MenuService menuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(RoleDTO roleDTO) {
        //DTO转换Entity
        RoleDO roleDO = BeanUtil.copyProperties(roleDTO, RoleDO.class);
        //保存
        roleRepository.save(roleDO);
        //保存角色菜单信息
        roleMenuService.createList(roleDO.getId(), roleDTO.getMenuIds());

    }

    @Override
    public void deleteByIds(List<Long> ids) {
        roleRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(RoleDTO roleDTO) {
        //获取id
        Long id = roleDTO.getId();
        //获取角色信息
        Optional<RoleDO> optional = roleRepository.findById(id);
        //判断用户是否不为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.ROLE_NULL_ERROR);
        }
        //获取用户
        RoleDO roleDO = optional.get();
        //DTO转换Entity
        ConverterUtil.to(roleDTO, roleDO);
        //保存
        roleRepository.save(roleDO);
        //删除角色菜单集
        roleMenuService.deleteByRoleId(id);
        //保存角色菜单信息
        roleMenuService.createList(id, roleDTO.getMenuIds());
    }

    @Override
    public RoleVO readById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<RoleVO> readListByParam(RoleParam roleParam) {
        return roleMapper.selectListByParam(roleParam);
    }

    @Override
    public List<MenuVO> readMenuTree() {
        return menuService.readTreeByParentId(SystemConstant.MENU_ROOT_ID);
    }
}
