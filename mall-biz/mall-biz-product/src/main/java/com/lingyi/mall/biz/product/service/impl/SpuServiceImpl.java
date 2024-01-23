package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.model.dto.SpuDTO;
import com.lingyi.mall.biz.product.model.entity.SpuDO;
import com.lingyi.mall.biz.product.dao.mapper.SpuMapper;
import com.lingyi.mall.biz.product.model.query.SpuQuery;
import com.lingyi.mall.biz.product.dao.repository.SpuRepository;
import com.lingyi.mall.biz.product.service.SpuService;
import com.lingyi.mall.biz.product.model.vo.SpuVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 9:29
 * @Description:
 */
@Service
public class SpuServiceImpl extends BaseServiceProImpl<SpuRepository, SpuMapper, SpuDTO, SpuVO, SpuQuery, SpuDO, Long> implements SpuService {


    @Override
    public void add(SpuDTO spuDTO) {

    }

    @Override
    public void editById(SpuDTO spuDTO) {

    }

}
