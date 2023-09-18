package com.lingyi.mall.biz.product.vo;

import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:01
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "属性值")
public class AttributeValueVO extends BaseIdVO<Long> {


    @Serial
    private static final long serialVersionUID = 8070481828265261801L;

    @Schema(description = "属性值名称")
    private String name;


}
