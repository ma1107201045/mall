package com.lingyi.mall.biz.product.dao.repository;

import com.lingyi.mall.biz.product.model.entity.SkuEvaluateDO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:17
 * @Description:
 */
@Repository
public interface SpuAttributeRepository extends JpaRepositoryImplementation<SpuAttributeDO, Long> {

    /**
     * 按照商品id删除
     *
     * @param spuIds 商品id
     */
    @Modifying
    @Query("DELETE FROM SpuAttributeDO WHERE spu.id in ?1")
    void deleteBySpuIds(List<Long> spuIds);
}
