package com.lingyi.mall.biz.sms.repositroy;

import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:15
 * @description
 */
public interface CaptchaLogRepository extends JpaRepositoryImplementation<CaptchaLogDO, Long> {
}
