package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.dao.mapper.SpuMapper;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.dao.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.SkuService;
import com.lingyi.mall.biz.product.service.SpuAttributeService;
import com.lingyi.mall.biz.product.service.SpuAttributeValueService;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:29
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuServiceImpl extends BaseServiceProImpl<SpuRepository, SpuMapper, SpuDTO, SpuVO, SpuQuery, SpuDO, Long> implements SpuService {

    private final SpuAttributeService spuAttributeService;

    private final SpuAttributeValueService spuAttributeValueService;

    private final SkuService skuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(SpuDTO spuDTO) {
        verifyData(spuDTO);

        var id = create(spuDTO, SpuDO.class);

        var spuAttributeDtoList = spuDTO.getSpuAttributeDTOList();

        var spuAttributeIdList = spuAttributeService.createBatch(id, spuAttributeDtoList);

        spuAttributeValueService.createBatch(spuAttributeIdList, spuAttributeDtoList);

        skuService.createBatch(id, spuDTO.getSkuDTOList());
    }

    @Override
    public void updateByDTO(SpuDTO spuDTO) {

    }


    private void verifyData(SpuDTO spuDTO) {

    }

}
