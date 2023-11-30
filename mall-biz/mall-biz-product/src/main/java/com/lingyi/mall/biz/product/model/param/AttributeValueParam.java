package com.lingyi.mall.biz.product.model.param;

import com.lingyi.mall.common.core.param.BasePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:04
 * @Description:
 */
@Schema
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AttributeValueParam extends BasePageParam {
}
