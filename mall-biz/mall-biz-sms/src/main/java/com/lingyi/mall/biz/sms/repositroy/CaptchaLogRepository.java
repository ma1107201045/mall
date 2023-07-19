package com.lingyi.mall.biz.sms.repositroy;

import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:15
 * @description
 */
@Repository
public interface CaptchaLogRepository extends JpaRepositoryImplementation<CaptchaLogDO, Long> {
}
