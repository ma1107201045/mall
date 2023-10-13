package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.biz.system.converter.UserRoleConverter;
import com.lingyi.mall.biz.system.dao.repository.UserRoleRepository;
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
    public void createList(Long userId, List<Long> roleIds) {
        var userRoles = UserRoleConverter.INSTANCE.of(userId, roleIds);
        userRoleRepository.saveAll(userRoles);
    }


    @Override
    public void deleteByUserIds(List<Long> userIds) {
        userRoleRepository.deleteByUserIds(userIds);
    }
}
