package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuRepository;
import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.model.entity.SpuDetailsDO;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.biz.product.service.*;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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

    private final SpuDetailsService spuDetailsService;

    private final SpuAttributeService spuAttributeService;

    private final SpuAttributeValueService spuAttributeValueService;

    private final SkuService skuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SpuDTO spuDTO) {

        verifyData(spuDTO);

        var id = create(spuDTO, SpuDO.class);

        spuDetailsService.add(spuDTO.getSpuDetailsDTO());

        var spuAttributeIds = spuAttributeService.addBatch(id, spuDTO.getSpuAttributeDTOList());

        spuAttributeValueService.addBatch(id, spuAttributeIds, spuDTO.getSpuAttributeDTOList());

        skuService.addBatch(id, spuDTO.getSkuDTOList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(SpuDTO spuDTO) {
        verifyData(spuDTO);

        var id = updateById(spuDTO, SpuDO.class);
        spuDetailsService.editById(spuDTO.getSpuDetailsDTO());

        spuAttributeService.removeBySpuIds(Collections.singletonList(id));
        var spuAttributeIds = spuAttributeService.addBatch(id, spuDTO.getSpuAttributeDTOList());

        spuAttributeValueService.removeBySpuIds(Collections.singletonList(id));
        spuAttributeValueService.addBatch(id, spuAttributeIds, spuDTO.getSpuAttributeDTOList());

        skuService.removeBySpuIds(Collections.singletonList(id));
        skuService.addBatch(id, spuDTO.getSkuDTOList());
    }

    @Override
    public void removeByIds(List<Long> ids) {

        deleteByIds(ids);

        spuDetailsService.removeBySpuIds(ids);

        spuAttributeService.removeBySpuIds(ids);

        spuAttributeValueService.removeBySpuIds(ids);

        skuService.removeBySpuIds(ids);

    }

    @Override
    public SpuVO getById(Long id) {
        return null;
    }

    @Override
    public List<SpuVO> getListByQuery(SpuQuery spuQuery) {
        return null;
    }


    private void verifyData(SpuDTO spuDTO) {

    }

}
