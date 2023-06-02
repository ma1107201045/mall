package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.dto.RoleDTO;
import com.lingyi.mall.api.system.entity.Role;
import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.enums.SystemFailEnum;
import com.lingyi.mall.api.system.param.RoleParam;
import com.lingyi.mall.api.system.vo.RoleVO;
import com.lingyi.mall.biz.system.mapper.RoleMapper;
import com.lingyi.mall.biz.system.repository.RoleRepository;
import com.lingyi.mall.biz.system.service.RoleMenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(RoleDTO roleDTO) {
        //DTO转换Entity
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        //保存
        roleRepository.save(role);
        //保存角色菜单信息
        roleMenuService.saveList(role.getId(), roleDTO.getMenuIds());

    }

    @Override
    public void removeByIds(List<Long> ids) {
        roleRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(RoleDTO roleDTO) {
        //获取id
        Long id = roleDTO.getId();
        //获取角色信息
        Optional<Role> optional = roleRepository.findById(id);
        //判断用户是否不为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.ROLE_NULL_ERROR);
        }
        //获取用户
        Role role = optional.get();
        //DTO转换Entity
        ConverterUtil.to(roleDTO, role);
        //保存
        roleRepository.save(role);
        //删除角色菜单集
        roleMenuService.removeByRoleId(id);
        //保存角色菜单信息
        roleMenuService.saveList(id, roleDTO.getMenuIds());
    }

    @Override
    public RoleVO findById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<RoleVO> findListByPageAndParam(BasePageParam basePageParam, RoleParam roleParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return roleMapper.selectListByParam(roleParam);
    }
}
