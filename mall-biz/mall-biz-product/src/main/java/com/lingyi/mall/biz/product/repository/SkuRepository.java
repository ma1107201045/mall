package com.lingyi.mall.biz.product.repository;

import com.lingyi.mall.biz.product.entity.SkuDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:24
 * @Description:
 */
@Repository
public interface SkuRepository extends JpaRepositoryImplementation<SkuDO, Long> {
}
