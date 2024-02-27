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
    List<Long> createBatch(Long spuId, List<SpuAttributeDTO> spuAttributeDTOList);


    /**
     * 批量删除
     *
     * @param spuAttributeIds ..
     */
    void deleteBySpuAttributeIds(List<Long> spuAttributeIds);
}
