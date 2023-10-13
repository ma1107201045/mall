package com.lingyi.mall.biz.system.dao.repository;


import com.lingyi.mall.biz.system.model.entity.UserDO;
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
public interface UserRepository extends JpaRepositoryImplementation<UserDO, Long> {

    @Query("SELECT id FROM UserDO WHERE userName = ?1")
    Long findIdByUserName(String userName);


}