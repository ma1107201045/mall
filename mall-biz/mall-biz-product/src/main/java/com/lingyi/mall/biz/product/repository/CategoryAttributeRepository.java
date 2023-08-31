package com.lingyi.mall.biz.product.repository;

import com.lingyi.mall.biz.product.entity.CategoryAttributeDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:26
 * @Description:
 */
@Repository
public interface CategoryAttributeRepository extends JpaRepositoryImplementation<CategoryAttributeDO, Long> {
}
