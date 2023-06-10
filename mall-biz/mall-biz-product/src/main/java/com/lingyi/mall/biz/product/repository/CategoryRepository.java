package com.lingyi.mall.biz.product.repository;

import com.lingyi.mall.biz.product.entity.CategoryDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/10 11:13
 * @description
 */
public interface CategoryRepository extends JpaRepositoryImplementation<CategoryDO, Long> {
}
