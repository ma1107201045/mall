package com.lingyi.mall.biz.system.service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 19:28
 * @Description:
 */
public interface UserRoleService {

    /**
     * 保存多条
     *
     * @param userId  用户id
     * @param roleIds 角色id集
     */
    void createList(Long userId, List<Long> roleIds);


    /**
     * 按照用户id删除用户角色
     *
     * @param userId 用户id
     */
    void deleteByUserId(Long userId);
}
