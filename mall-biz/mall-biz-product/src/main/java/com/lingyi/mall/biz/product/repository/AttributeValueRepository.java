package com.lingyi.mall.biz.product.repository;

import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:50
 * @Description:
 */
@Repository
public interface AttributeValueRepository extends JpaRepositoryImplementation<AttributeValueDO, Long> {
}
