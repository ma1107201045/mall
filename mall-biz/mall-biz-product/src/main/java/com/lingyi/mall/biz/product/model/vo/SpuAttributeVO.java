package com.lingyi.mall.biz.product.model.vo;

import com.lingyi.mall.common.core.dto.BaseIdDTO;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/10/27 12:15
 * @Description:
 */
@Schema
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuAttributeVO extends BaseIdVO<Long> {


    @Serial
    private static final long serialVersionUID = -7194926881306455948L;
}
