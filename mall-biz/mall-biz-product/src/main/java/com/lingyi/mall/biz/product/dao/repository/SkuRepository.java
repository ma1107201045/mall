package com.lingyi.mall.biz.product.dao.repository;

import com.lingyi.mall.biz.product.model.entity.SkuDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:24
 * @Description:
 */
@Repository
public interface SkuRepository extends JpaRepositoryImplementation<SkuDO, Long> {
    /**
     * 按照商品id删除
     *
     * @param spuId 商品id
     */
    @Modifying
    @Query("DELETE FROM SpuAttributeDO WHERE spu.id in ?1")
    void deleteBySpuIds(List<Long> spuId);
}
