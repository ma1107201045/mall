package com.lingyi.mall.biz.member.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.lang.reflect.Member;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 14:17
 * @description
 */
public interface MbmMemberRepository extends JpaRepositoryImplementation<Member, Long> {
}
