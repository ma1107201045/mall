package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.model.dto.SpuAttributeDTO;
import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.dao.mapper.SpuMapper;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.dao.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.*;
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

    private final SpuDetailsService spuDetailsService;

    private final SpuAttributeService spuAttributeService;

    private final SpuAttributeValueService spuAttributeValueService;

    private final SkuService skuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SpuDTO spuDTO) {

        verifyData(spuDTO);

        var id = create(spuDTO, SpuDO.class);

        spuDetailsService.add(spuDTO.getContent());

        var spuAttributeIdList = spuAttributeService.addBatch(id, spuDTO.getSpuAttributeDTOList());

        spuAttributeValueService.addBatch(spuAttributeIdList, spuDTO.getSpuAttributeDTOList());

        skuService.addBatch(id, spuDTO.getSkuDTOList());
    }

    @Override
    public void editById(SpuDTO spuDTO) {

    }

    @Override
    public void removeByIds(List<Long> ids) {

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
