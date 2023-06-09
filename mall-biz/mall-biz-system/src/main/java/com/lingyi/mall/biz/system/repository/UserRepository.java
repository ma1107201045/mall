package com.lingyi.mall.biz.system.repository;


import com.lingyi.mall.biz.system.entity.UserDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
public interface UserRepository extends JpaRepositoryImplementation<UserDO, Long> {

}