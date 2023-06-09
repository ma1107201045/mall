package com.lingyi.mall.biz.system.repository;

import com.lingyi.mall.biz.system.entity.LogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:29
 * @description
 */
public interface LogRepository extends JpaRepositoryImplementation<LogDO, Long> {
}
