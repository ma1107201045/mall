package com.lingyi.mall.biz.system.dao.repository;


import com.lingyi.mall.biz.system.model.entity.UserRoleDO;
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
public interface UserRoleRepository extends JpaRepositoryImplementation<UserRoleDO, Long> {

    /**
     * 按照用户id删除
     *
     * @param userIds 用户id集
     */
    @Modifying
    @Query("DELETE FROM UserRoleDO WHERE user.id in ?1")
    void deleteByUserIds(List<Long> userIds);
}