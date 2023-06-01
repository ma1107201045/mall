package com.lingyi.mall.biz.system.repository;

import com.lingyi.mall.api.system.entity.RoleMenu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
public interface RoleMenuRepository extends JpaRepositoryImplementation<RoleMenu, Long> {

    /**
     * 按照角色id删除
     *
     * @param roleId 角色id
     */
    @Modifying
    @Query("DELETE FROM RoleMenu  WHERE role.id=?1")
    void deleteByRoleId(Long roleId);
}