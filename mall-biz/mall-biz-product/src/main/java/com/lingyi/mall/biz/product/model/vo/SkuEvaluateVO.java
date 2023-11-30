package com.lingyi.mall.biz.product.model.vo;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/11/28 10:19
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SkuEvaluateVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = -830952698862150585L;
}

