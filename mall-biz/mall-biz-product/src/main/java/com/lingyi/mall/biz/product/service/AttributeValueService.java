package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.AttributeValueDTO;
import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.model.param.AttributeValueParam;
import com.lingyi.mall.biz.product.model.vo.AttributeValueVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:48
 * @Description:
 */
public interface AttributeValueService extends BaseServicePro<AttributeValueDTO, AttributeValueVO, AttributeValueParam, AttributeValueDO, Long> {

    /**
     * 批量创建属性值
     *
     * @param attributeId 屬性名id
     * @param names       属性值名称集
     */
    void createList(Long attributeId, List<String> names);

    /**
     * 通过屬性名id删除
     *
     * @param attributeIds 屬性名id集合
     */
    void deleteByAttributeIds(List<Long> attributeIds);
}
