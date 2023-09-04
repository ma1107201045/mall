package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dto.BrandDTO;
import com.lingyi.mall.biz.product.entity.BrandDO;
import com.lingyi.mall.biz.product.entity.SpuDO;
import com.lingyi.mall.biz.product.mapper.BrandMapper;
import com.lingyi.mall.biz.product.repository.BrandRepository;
import com.lingyi.mall.biz.product.service.BrandService;
import com.lingyi.mall.biz.product.vo.BrandVO;
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
    public void create(BrandDTO brandDTO) {
        BrandDO brandDO = ConverterUtil.to(brandDTO, BrandDO.class);
        brandRepository.save(brandDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        brandRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(BrandDTO brandDTO) {
        var optional = brandRepository.findById(brandDTO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var brandDO = optional.get();
        ConverterUtil.to(brandDTO, brandDO);
        brandRepository.save(brandDO);
    }

    @Override
    public BrandVO readById(Long id) {
        return null;
    }

    @Override
    public List<BrandVO> readListByParam(BasePageParam param) {
        return null;
    }
}
