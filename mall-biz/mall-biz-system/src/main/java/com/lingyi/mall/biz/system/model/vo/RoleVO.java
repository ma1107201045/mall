package com.lingyi.mall.biz.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:20
 * @description
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色")
public class RoleVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = -855349452886457254L;


    @Schema(description = "角色名称")
    private String name;

    @Schema(description = " 是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "顺序")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

    @Schema(description = "最后一次更新人")
    private String lastModifyBy;

    @Schema(description = "最后一次更新时间")
    private LocalDateTime lastModifyDateTime;

    @Schema(description = "菜单id集")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> menuIds;
}
