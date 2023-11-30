package com.lingyi.mall.biz.product.dao.repository;

import com.lingyi.mall.biz.product.model.entity.SpuCollectDO;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:19
 * @Description:
 */
@Repository
public interface SpuCollectRepository extends JpaRepositoryImplementation<SpuCollectDO, Long> {
}
