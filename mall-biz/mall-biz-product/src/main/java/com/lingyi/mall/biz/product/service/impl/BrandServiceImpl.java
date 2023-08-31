package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.entity.SpuDO;
import com.lingyi.mall.biz.product.mapper.BrandMapper;
import com.lingyi.mall.biz.product.repository.BrandRepository;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        brandRepository.save(brandDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        brandRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(BrandDO brandDO) {
        var optional = brandRepository.findById(brandDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newBrandDO = optional.get();
        ConverterUtil.to(brandDO, newBrandDO);
        brandRepository.save(newBrandDO);
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
