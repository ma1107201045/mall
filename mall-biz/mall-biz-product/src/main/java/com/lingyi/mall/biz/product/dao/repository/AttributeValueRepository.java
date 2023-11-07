package com.lingyi.mall.biz.product.dao.repository;

import com.lingyi.mall.biz.product.model.entity.AttributeValueDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:50
 * @Description:
 */
@Repository
public interface AttributeValueRepository extends JpaRepositoryImplementation<AttributeValueDO, Long> {

    /**
     * 按照用户id删除
     *
     * @param attributeIds 属性id
     */
    @Modifying
    @Query("DELETE FROM AttributeValueDO WHERE attribute.id in ?1")
    void deleteByAttributeIds(List<Long> attributeIds);

}
