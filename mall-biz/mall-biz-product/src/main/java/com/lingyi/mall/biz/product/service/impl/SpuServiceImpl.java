package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.SpuDO;
import com.lingyi.mall.biz.product.mapper.SpuMapper;
import com.lingyi.mall.biz.product.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.common.orm.param.BasePageParam;
import com.lingyi.mall.common.core.util.ConverterUtil;
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
        spuRepository.save(spuDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        spuRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(SpuDO spuDO) {
        var optional = spuRepository.findById(spuDO.getId());
        if (optional.isEmpty()) {
            return;
        }
        var newSpuDO = optional.get();
        ConverterUtil.to(spuDO, newSpuDO);
        spuRepository.save(newSpuDO);
    }

    @Override
    public SpuDO readById(Long id) {
        return null;
    }

    @Override
    public List<SpuDO> readListByParam(BasePageParam param) {
        return null;
    }
}
