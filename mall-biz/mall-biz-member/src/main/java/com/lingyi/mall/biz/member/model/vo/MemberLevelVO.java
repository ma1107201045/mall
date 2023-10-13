package com.lingyi.mall.biz.member.model.vo;

import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/14 15:27
 * @description
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "会员等级")
public class MemberLevelVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = 5004987282353659490L;

    @Schema(description = "等级名称")
    private String name;

    @Schema(description = "增长点")
    private Integer growthPoint;

    @Schema(description = "每次评价获取的成长值")
    private Integer commentGrowthPoint;

    @Schema(description = "是否为默认等级：1是 0否")
    private Integer isDefaultLevel;

    @Schema(description = "是否有免邮特权:1 是 0 否")
    private Integer isPriviledgeFreeFreight;

    @Schema(description = "是否有签到特权:1 是 0 否")
    private Integer isPriviledgeSignIn;

    @Schema(description = "是否有评论获奖励特权:1 是 0 否")
    private Integer isPriviledgeComment;

    @Schema(description = "是否有专享活动特权:1 是 0 否")
    private Integer isPriviledgePromotion;

    @Schema(description = "是否有会员价格特权:1 是 0 否")
    private Integer isPriviledgeMemberPrice;

    @Schema(description = "是否有生日特权:1 是 0 否")
    private Integer isPriviledgeBirthday;

    @Schema(description = "免运费标准")
    private BigDecimal freeFreightPoint;

    @Schema(description = "备注")
    private String remark;
}
