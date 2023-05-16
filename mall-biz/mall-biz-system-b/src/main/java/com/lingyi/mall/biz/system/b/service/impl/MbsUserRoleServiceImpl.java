package com.lingyi.mall.biz.system.b.service.impl;

import com.lingyi.mall.api.system.b.entity.UserRole;
import com.lingyi.mall.biz.system.b.repository.MbsUserRoleRepository;
import com.lingyi.mall.biz.system.b.service.MbsUserRoleService;
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

    @Override
    public void addList(Long userId, List<Long> roleIds) {
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
