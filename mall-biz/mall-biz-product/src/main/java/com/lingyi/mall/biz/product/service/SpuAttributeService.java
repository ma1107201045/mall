package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:07
 * @Description:
 */
public interface SpuAttributeService {


    /**
     * 批量添加
     *
     * @param spuId               spuId
     * @param spuAttributeDTOList spuAttributeDTOList
     */
    List<Long> addBatch(Long spuId, List<SpuAttributeDTO> spuAttributeDTOList);


    /**
     * 删除
     *
     * @param spuIds ..
     */
    void removeBySpuIds(List<Long> spuIds);
}
