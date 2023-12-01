package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SkuEvaluateDTO;
import com.lingyi.mall.biz.product.model.dto.SkuEvaluateReplyDTO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateDO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateReplyDO;
import com.lingyi.mall.biz.product.model.param.SkuEvaluateParam;
import com.lingyi.mall.biz.product.model.param.SkuEvaluateReplyParam;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateReplyVO;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 14:16
 * @Description:
 */
public interface SkuEvaluateReplyService extends BaseServicePro<SkuEvaluateReplyDTO, SkuEvaluateReplyVO,
        SkuEvaluateReplyParam, SkuEvaluateReplyDO, Long> {
}
