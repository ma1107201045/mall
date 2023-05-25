package com.lingyi.mall.biz.member.mapper;

import com.lingyi.mall.api.member.entity.MemberLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:40
 * @description
 */
@Mapper
public interface MbmMemberLoginLogMapper extends JpaRepositoryImplementation<MemberLoginLog, Long> {
}
