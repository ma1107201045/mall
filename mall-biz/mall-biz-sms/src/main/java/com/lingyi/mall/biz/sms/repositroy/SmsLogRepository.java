package com.lingyi.mall.biz.sms.repositroy;

import com.lingyi.mall.biz.sms.entity.SmsLogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:15
 * @description
 */
public interface SmsLogRepository extends JpaRepositoryImplementation<SmsLogDO, Long> {
}
