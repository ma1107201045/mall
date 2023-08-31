package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.SpuDO;
import com.lingyi.mall.biz.product.mapper.SkuMapper;
import com.lingyi.mall.biz.product.mapper.SpuMapper;
import com.lingyi.mall.biz.product.repository.SkuRepository;
import com.lingyi.mall.biz.product.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.common.base.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:29
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuServiceImpl implements SpuService {

    private final SpuRepository spuRepository;

    private final SpuMapper spuMapper;

    @Override
    public void create(SpuDO spuDO) {

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(SpuDO spuDO) {

    }

    @Override
    public SpuDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<SpuDO> readListByParam(BasePageParam param) {
        return null;
    }
}
