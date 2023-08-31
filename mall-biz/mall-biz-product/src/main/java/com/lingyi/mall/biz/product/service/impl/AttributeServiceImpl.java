package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.AttributeDO;
import com.lingyi.mall.biz.product.mapper.AttributeMapper;
import com.lingyi.mall.biz.product.repository.AttributeRepository;
import com.lingyi.mall.biz.product.service.AttributeService;
import com.lingyi.mall.common.base.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:46
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    @Override
    public void create(AttributeDO attributeDO) {

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(AttributeDO attributeDO) {

    }

    @Override
    public AttributeDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<AttributeDO> readListByParam(BasePageParam param) {
        return null;
    }
}
