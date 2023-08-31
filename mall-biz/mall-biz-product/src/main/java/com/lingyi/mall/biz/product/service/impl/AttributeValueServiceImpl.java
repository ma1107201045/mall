package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.entity.AttributeValueDO;
import com.lingyi.mall.biz.product.mapper.AttributeValueMapper;
import com.lingyi.mall.biz.product.repository.AttributeValueRepository;
import com.lingyi.mall.biz.product.service.AttributeValueService;
import com.lingyi.mall.common.base.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:48
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {


    private final AttributeValueRepository attributeValueRepository;

    private final AttributeValueMapper attributeValueMapper;

    @Override
    public void create(AttributeValueDO attributeValueDO) {

    }

    @Override
    public void deleteByIds(List<Long> longs) {

    }

    @Override
    public void updateById(AttributeValueDO attributeValueDO) {

    }

    @Override
    public AttributeValueDO readById(Long aLong) {
        return null;
    }

    @Override
    public List<AttributeValueDO> readListByParam(BasePageParam param) {
        return null;
    }
}
