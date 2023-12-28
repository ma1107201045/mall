package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SkuEvaluateCommentMapper;
import com.lingyi.mall.biz.product.dao.repository.SkuEvaluateCommentRepository;
import com.lingyi.mall.biz.product.model.dto.SkuEvaluateCommentDTO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateCommentDO;
import com.lingyi.mall.biz.product.model.query.SkuEvaluateCommentQuery;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateCommentVO;
import com.lingyi.mall.biz.product.service.SkuEvaluateCommentService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 10:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SkuEvaluateCommentServiceImpl extends BaseServiceProImpl<SkuEvaluateCommentRepository,
        SkuEvaluateCommentMapper, SkuEvaluateCommentDTO, SkuEvaluateCommentVO, SkuEvaluateCommentQuery, SkuEvaluateCommentDO, Long> implements SkuEvaluateCommentService {
}
