package com.lingyi.mall.biz.product.dao.repository;

import com.lingyi.mall.biz.product.model.entity.SkuEvaluateDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:17
 * @Description:
 */
@Repository
public interface SpuAttributeRepository extends JpaRepositoryImplementation<SpuAttributeDO, Long> {
}
