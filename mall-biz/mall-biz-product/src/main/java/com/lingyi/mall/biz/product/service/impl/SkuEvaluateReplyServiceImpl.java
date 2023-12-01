package com.lingyi.mall.biz.product.service.impl;

import com.lingyi.mall.biz.product.dao.mapper.SkuEvaluateReplyMapper;
import com.lingyi.mall.biz.product.dao.repository.SkuEvaluateReplyRepository;
import com.lingyi.mall.biz.product.model.dto.SkuEvaluateReplyDTO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateReplyDO;
import com.lingyi.mall.biz.product.model.param.SkuEvaluateReplyParam;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateReplyVO;
import com.lingyi.mall.biz.product.service.SkuEvaluateReplyService;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 14:03
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class SkuEvaluateReplyServiceImpl extends BaseServiceProImpl<SkuEvaluateReplyRepository,
        SkuEvaluateReplyMapper, SkuEvaluateReplyDTO, SkuEvaluateReplyVO, SkuEvaluateReplyParam, SkuEvaluateReplyDO, Long>
        implements SkuEvaluateReplyService {
}
