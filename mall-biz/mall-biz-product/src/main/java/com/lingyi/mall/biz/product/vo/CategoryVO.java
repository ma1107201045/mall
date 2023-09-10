package com.lingyi.mall.biz.product.vo;

import com.lingyi.mall.common.orm.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:02
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "分类")
public class CategoryVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = -1128091138999932809L;

}
