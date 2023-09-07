package com.lingyi.mall.biz.system.converter;

import com.lingyi.mall.biz.system.entity.RoleDO;
import com.lingyi.mall.biz.system.entity.UserDO;
import com.lingyi.mall.biz.system.entity.UserRoleDO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/7 16:54
 * @Description:
 */
public final class UserRoleConverter {

    public static final UserRoleConverter INSTANCE = new UserRoleConverter();

    private UserRoleConverter() {

    }


    public UserRoleDO of(Long userId, Long roleId) {
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        RoleDO roleDO = new RoleDO();
        roleDO.setId(roleId);
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUserDO(userDO);
        userRoleDO.setRoleDO(roleDO);
        return userRoleDO;
    }

    public List<UserRoleDO> of(Long userId, List<Long> roleIds) {
        return roleIds.stream()
                .map(roleId -> of(userId, roleId))
                .toList();
    }
}
