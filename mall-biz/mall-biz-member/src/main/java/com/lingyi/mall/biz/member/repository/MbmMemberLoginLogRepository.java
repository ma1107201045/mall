package com.lingyi.mall.biz.member.repository;

import com.lingyi.mall.api.member.entity.MemberLoginLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
public interface MbmMemberLoginLogRepository extends JpaRepositoryImplementation<MemberLoginLog, Long> {
}
