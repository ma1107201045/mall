package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.model.dto.SkuDTO;
import com.lingyi.mall.biz.product.model.entity.SkuDO;
import com.lingyi.mall.biz.product.dao.mapper.SkuMapper;
import com.lingyi.mall.biz.product.model.query.SkuQuery;
import com.lingyi.mall.biz.product.dao.repository.SkuRepository;
import com.lingyi.mall.biz.product.service.SkuService;
import com.lingyi.mall.biz.product.model.vo.SkuVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:33
 * @Description:
 */
@Service
public class SkuServiceImpl extends BaseServiceProImpl<SkuRepository, SkuMapper, SkuDTO, SkuVO, SkuQuery, SkuDO, Long> implements SkuService {


    @Override
    public void addBatch(Long spuId, List<SkuDTO> skuDTOList) {

    }
}
