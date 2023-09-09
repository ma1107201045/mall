package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.SkuDO;
import com.lingyi.mall.biz.product.mapper.SkuMapper;
import com.lingyi.mall.biz.product.repository.SkuRepository;
import com.lingyi.mall.biz.product.service.SkuService;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:33
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SkuServiceImpl implements SkuService {

    private final SkuRepository skuRepository;

    private final SkuMapper skuMapper;

    @Override
    public void create(SkuDO skuDO) {
        skuRepository.save(skuDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        skuRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(SkuDO skuDO) {
        var optional  = skuRepository.findById(skuDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newSkuDO = optional.get();
        ConverterUtil.to(skuDO, newSkuDO);
        skuRepository.save(skuDO);
    }

    @Override
    public SkuDO readById(Long id) {
        return null;
    }

    @Override
    public List<SkuDO> readListByParam(BasePageParam param) {
        return null;
    }
}
