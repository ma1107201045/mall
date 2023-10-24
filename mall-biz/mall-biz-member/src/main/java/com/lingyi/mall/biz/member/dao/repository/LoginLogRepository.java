package com.lingyi.mall.biz.member.dao.repository;

import com.lingyi.mall.biz.member.model.entity.LoginLogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Repository
public interface LoginLogRepository extends JpaRepositoryImplementation<LoginLogDO, Long> {


}
