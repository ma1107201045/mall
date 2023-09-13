package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.dto.AttributeDTO;
import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.param.AttributeParam;
import com.lingyi.mall.biz.product.vo.AttributeVO;
import com.lingyi.mall.common.orm.util.BaseService;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
public interface AttributeService extends BaseServicePro<AttributeDTO, AttributeVO, AttributeParam, AttributeDO, Long> {

    /**
     * 保存属性以及属性值
     *
     * @param attributeDTO 。。
     */
    void save(AttributeDTO attributeDTO);
}
