package com.lingyi.mall.biz.system.dao.repository;

import com.lingyi.mall.biz.system.model.entity.LogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:29
 * @description
 */
@Repository
public interface LogRepository extends JpaRepositoryImplementation<LogDO, Long> {
}
