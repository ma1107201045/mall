package com.lingyi.mall.biz.system.repository;

import com.lingyi.mall.biz.system.entity.MbsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
public interface MbsUserRepository extends JpaRepository<MbsUser, Long>, JpaSpecificationExecutor<MbsUser> {
}