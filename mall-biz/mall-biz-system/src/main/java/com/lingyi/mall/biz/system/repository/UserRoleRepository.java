package com.lingyi.mall.biz.system.repository;


import com.lingyi.mall.biz.system.entity.UserRoleDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

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
     * @param userId 用户id
     */
    @Modifying
    @Query("DELETE FROM UserRoleDO WHERE userDO.id = ?1")
    void deleteByUserId(Long userId);
}