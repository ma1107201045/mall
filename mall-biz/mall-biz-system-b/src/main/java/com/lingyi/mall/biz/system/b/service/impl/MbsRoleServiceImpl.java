package com.lingyi.mall.biz.system.b.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.b.dto.RoleDTO;
import com.lingyi.mall.api.system.b.entity.Role;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.enums.MbsFailEnum;
import com.lingyi.mall.api.system.b.param.RoleParam;
import com.lingyi.mall.api.system.b.vo.RoleVO;
import com.lingyi.mall.biz.system.b.mapper.MbsRoleMapper;
import com.lingyi.mall.biz.system.b.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.b.service.MbsRoleMenuService;
import com.lingyi.mall.biz.system.b.service.MbsRoleService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import com.lingyi.mall.common.bean.util.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsRoleServiceImpl implements MbsRoleService {

    private final MbsRoleRepository mbsRoleRepository;

    private final MbsRoleMapper mbsRoleMapper;

    private final MbsRoleMenuService mbsRoleMenuService;

    @Override
    public void add(RoleDTO roleDTO) {
        //转换
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        //保存
        mbsRoleRepository.save(role);
        //保存角色菜单信息
        mbsRoleMenuService.saveList(role.getId(), roleDTO.getMenuIds());

    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsRoleRepository.deleteAllById(ids);
    }

    @Override
    public void editById(RoleDTO roleDTO) {
        //断言menuId不为空
        AssertUtil.notNull(roleDTO.getRoleId(), MbsFailEnum.ROLE_ID_NULL_ERROR);
        //转换
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        role.setId(roleDTO.getRoleId());
        //保存
        mbsRoleRepository.save(role);
        //保存角色菜单信息
        mbsRoleMenuService.saveList(role.getId(), roleDTO.getMenuIds());
    }

    @Override
    public RoleVO findById(Long id) {
        return mbsRoleMapper.selectById(id);
    }

    @Override
    public List<RoleVO> findListByPageAndParam(BasePageParam basePageParam, RoleParam roleParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize());
        return mbsRoleMapper.selectListByParam(roleParam);
    }
}
