package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.mapper.BrandMapper;
import com.lingyi.mall.biz.product.repository.BrandRepository;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.common.base.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:42
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    @Override
    public void create(BrandDO brandDO) {

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(BrandDO brandDO) {

    }

    @Override
    public BrandDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<BrandDO> readListByParam(BasePageParam param) {
        return null;
    }
}
