package com.lingyi.mall.biz.system.b.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.b.entity.UserRole;
import com.lingyi.mall.api.system.b.param.UserRoleParam;
import com.lingyi.mall.api.system.b.vo.UserRoleVO;
import com.lingyi.mall.biz.system.b.mapper.MbsUserRoleMapper;
import com.lingyi.mall.biz.system.b.repository.MbsUserRoleRepository;
import com.lingyi.mall.biz.system.b.service.MbsUserRoleService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 19:29
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsUserRoleServiceImpl implements MbsUserRoleService {

    private final MbsUserRoleRepository mbsUserRoleRepository;

    private final MbsUserRoleMapper mbsUserRoleMapper;

    @Override
    public void add(UserRole userRole) {
        mbsUserRoleRepository.save(userRole);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsUserRoleRepository.deleteAllById(ids);
    }

    @Override
    public void editById(UserRole userRole) {
        mbsUserRoleRepository.save(userRole);
    }

    @Override
    public UserRoleVO findById(Long id) {
        return mbsUserRoleMapper.selectById(id);
    }

    @Override
    public List<UserRoleVO> findListByPageAndParam(BasePageParam basePageDTO, UserRoleParam userRoleParam) {
        PageHelper.startPage(basePageDTO.getCurrentPage(), basePageDTO.getPageSize());
        return mbsUserRoleMapper.selectListByParam(userRoleParam);
    }

    @Override
    public void saveList(Long userId, List<Long> roleIds) {
        List<UserRole> userRoles = roleIds.stream()
                .map(roleId -> UserRole.of(userId, roleId))
                .toList();
        mbsUserRoleRepository.saveAll(userRoles);
    }

    @Override
    public void removeByUserId(Long userId) {
        mbsUserRoleRepository.deleteByUserId(userId);
    }
}
