package com.lingyi.mall.biz.system.b.repository;

import com.lingyi.mall.api.system.b.entity.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
public interface MbsRoleRepository extends JpaRepositoryImplementation<Role, Long> {
}