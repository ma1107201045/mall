package com.lingyi.mall.biz.system.repository;

import com.lingyi.mall.biz.system.entity.MenuDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
@Repository
public interface MenuRepository extends JpaRepositoryImplementation<MenuDO, Long> {
}