package com.lingyi.mall.biz.info.dao.repositroy;

import com.lingyi.mall.biz.info.model.entity.LogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:15
 * @description
 */
@Repository
public interface SmsLogRepository extends JpaRepositoryImplementation<LogDO, Long> {
}
