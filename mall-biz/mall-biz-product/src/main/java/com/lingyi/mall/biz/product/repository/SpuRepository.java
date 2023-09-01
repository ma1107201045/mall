package com.lingyi.mall.biz.product.repository;

import com.lingyi.mall.biz.product.entity.SpuDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/10 11:14
 * @description
 */
@Repository
public interface SpuRepository extends JpaRepositoryImplementation<SpuDO, Long> {
}
