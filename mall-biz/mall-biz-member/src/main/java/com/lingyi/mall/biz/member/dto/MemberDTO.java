package com.lingyi.mall.biz.member.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingyi.mall.biz.member.entity.MemberDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:11
 * @description
 */
@Schema(description = "会员")
@Data
public class MemberDTO {

    @Schema(name = "memberId", description = "会员id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "会员id不能为空")
    @JsonAlias("memberId")
    private Long id;

    @Schema(description = "是否启用 1 是 0 否", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Long isEnable;
}
