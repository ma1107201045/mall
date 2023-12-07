package com.lingyi.mall.biz.product.model.vo;

import com.lingyi.mall.biz.product.model.entity.BrandDO;
import com.lingyi.mall.biz.product.model.entity.CategoryDO;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/8/31 16:00
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "spu")
public class SpuVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = 3494553046094143365L;

    private Long userId;

    private Long merchantId;

    private Long shopId;

    private Long brandId;

    private Long categoryId;

    private String name;

    private String brief;

    private String keywords;

    private String mainPic;

    private String pics;

    private BigDecimal marketPrice;

    private BigDecimal salePrice;

    private BigDecimal costPrice;

    private BigDecimal vipPrice;

    private BigDecimal isMail;

    private BigDecimal mailPrice;

    private BigDecimal unitName;

    private Integer sale;

    private Integer totalStock;

    private Integer seq;

    private Integer isUp;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

}
