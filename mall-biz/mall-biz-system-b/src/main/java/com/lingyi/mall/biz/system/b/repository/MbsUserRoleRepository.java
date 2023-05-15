package com.lingyi.mall.biz.system.b.repository;


import com.lingyi.mall.api.system.b.entity.UserRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
public interface MbsUserRoleRepository extends JpaRepositoryImplementation<UserRole, Long> {

    /**
     * 按照用户id删除
     *
     * @param userId 用户id
     */
    @Modifying
    @Query("DELETE FROM UserRole  WHERE user.id=?1")
    void deleteByUserId(Long userId);
}