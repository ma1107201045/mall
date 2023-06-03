package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.entity.UserRole;
import com.lingyi.mall.biz.system.repository.UserRoleRepository;
import com.lingyi.mall.biz.system.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public void addList(Long userId, List<Long> roleIds) {
        List<UserRole> userRoles = roleIds.stream()
                .map(roleId -> UserRole.of(userId, roleId))
                .toList();
        userRoleRepository.saveAll(userRoles);
    }

    @Override
    public void removeByUserId(Long userId) {
        userRoleRepository.deleteByUserId(userId);
    }
}
