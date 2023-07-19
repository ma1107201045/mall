package com.lingyi.mall.biz.member.repository;

import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Repository
public interface MemberLoginLogRepository extends JpaRepositoryImplementation<MemberLoginLogDO, Long> {


}
