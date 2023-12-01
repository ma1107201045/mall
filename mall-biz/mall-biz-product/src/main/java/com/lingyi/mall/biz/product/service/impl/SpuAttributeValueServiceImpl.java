package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SpuAttributeValueMapper;
import com.lingyi.mall.biz.product.dao.repository.SpuAttributeValueRepository;
import com.lingyi.mall.biz.product.model.dto.SpuAttributeValueDTO;
import com.lingyi.mall.biz.product.model.entity.SpuAttributeValueDO;
import com.lingyi.mall.biz.product.model.param.SpuAttributeValueParam;
import com.lingyi.mall.biz.product.model.vo.SpuAttributeValueVO;
import com.lingyi.mall.biz.product.service.SpuAttributeValueService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:32
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SpuAttributeValueServiceImpl extends BaseServiceProImpl<SpuAttributeValueRepository, SpuAttributeValueMapper, SpuAttributeValueDTO,
        SpuAttributeValueVO, SpuAttributeValueParam, SpuAttributeValueDO, Long> implements SpuAttributeValueService {
}
