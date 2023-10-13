package com.lingyi.mall.biz.system.dao.repository;

import com.lingyi.mall.biz.system.model.entity.RoleMenuDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
@Repository
public interface RoleMenuRepository extends JpaRepositoryImplementation<RoleMenuDO, Long> {

    /**
     * 按照角色id删除
     *
     * @param roleIds 角色id集
     */
    @Modifying
    @Query("DELETE FROM RoleMenuDO WHERE roleDO.id in ?1")
    void deleteByRoleIds(List<Long> roleIds);
}