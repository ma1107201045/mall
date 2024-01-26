package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.AttributeDTO;
import com.lingyi.mall.biz.product.model.entity.AttributeDO;
import com.lingyi.mall.biz.product.model.query.AttributeQuery;
import com.lingyi.mall.biz.product.model.vo.AttributeVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
public interface AttributeService extends BaseServicePro<AttributeDTO, AttributeVO, AttributeQuery, AttributeDO, Long> {

    /**
     * 保存属性以及属性值
     *
     * @param attributeDTO 。。
     */
    void create(AttributeDTO attributeDTO);

    /**
     * 更新属性以及属性值
     *
     * @param attributeDTO ..
     */
    void updateByDTO(AttributeDTO attributeDTO);
}
