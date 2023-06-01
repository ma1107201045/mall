package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.dto.RoleDTO;
import com.lingyi.mall.api.system.entity.Role;
import com.lingyi.mall.api.system.enums.SystemFailEnum;
import com.lingyi.mall.api.system.param.RoleParam;
import com.lingyi.mall.api.system.vo.RoleVO;
import com.lingyi.mall.biz.system.mapper.RoleMapper;
import com.lingyi.mall.biz.system.repository.RoleRepository;
import com.lingyi.mall.biz.system.service.RoleMenuService;
import com.lingyi.mall.biz.system.service.RoleService;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository mbsRoleRepository;

    private final RoleMapper mbsRoleMapper;

    private final RoleMenuService roleMenuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(RoleDTO roleDTO) {
        //转换
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        //保存
        mbsRoleRepository.save(role);
        //保存角色菜单信息
        roleMenuService.saveList(role.getId(), roleDTO.getMenuIds());

    }

    @Override
    public void removeByIds(List<Long> ids) {
        mbsRoleRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(RoleDTO roleDTO) {
        Long id = roleDTO.getId();
        //断言menuId不为空
        AssertUtil.notNull(id, SystemFailEnum.ROLE_ID_NULL_ERROR);
        //转换
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        //保存
        mbsRoleRepository.save(role);
        //删除角色菜单集
        roleMenuService.removeByRoleId(id);
        //保存角色菜单信息
        roleMenuService.saveList(id, roleDTO.getMenuIds());
    }

    @Override
    public RoleVO findById(Long id) {
        return mbsRoleMapper.selectById(id);
    }

    @Override
    public List<RoleVO> findListByPageAndParam(BasePageParam basePageParam, RoleParam roleParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
        return mbsRoleMapper.selectListByParam(roleParam);
    }
}
