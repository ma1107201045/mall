package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SkuEvaluateMapper;
import com.lingyi.mall.biz.product.dao.repository.SkuEvaluateRepository;
import com.lingyi.mall.biz.product.model.dto.SkuEvaluateDTO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateDO;
import com.lingyi.mall.biz.product.model.query.SkuEvaluateQuery;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateVO;
import com.lingyi.mall.biz.product.service.SkuEvaluateService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 10:20
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SkuEvaluateServiceImpl extends BaseServiceProImpl<SkuEvaluateRepository,
        SkuEvaluateMapper, SkuEvaluateDTO, SkuEvaluateVO, SkuEvaluateQuery, SkuEvaluateDO, Long> implements SkuEvaluateService {
}
