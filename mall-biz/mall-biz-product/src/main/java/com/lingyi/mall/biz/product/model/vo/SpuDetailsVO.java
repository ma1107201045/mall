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
 * @DateTime: 2023/11/27 16:16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuDetailsVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = 5648310311350028799L;
}
