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
@Schema(description = "分类属性")
public class CategoryAttributeVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = -5033758759175703753L;

}
