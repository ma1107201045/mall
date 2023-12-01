package com.lingyi.mall.biz.product.service;

import com.lingyi.mall.biz.product.model.dto.SkuEvaluateDTO;
import com.lingyi.mall.biz.product.model.entity.SkuEvaluateDO;
import com.lingyi.mall.biz.product.model.param.SkuEvaluateParam;
import com.lingyi.mall.biz.product.model.vo.SkuEvaluateVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/12/1 10:20
 * @Description:
 */
public interface SkuEvaluateService extends BaseServicePro<SkuEvaluateDTO, SkuEvaluateVO,
        SkuEvaluateParam, SkuEvaluateDO, Long> {
}
