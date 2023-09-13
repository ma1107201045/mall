package com.lingyi.mall.biz.member.dto;

import com.lingyi.mall.common.orm.dto.BaseIdDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2023/9/12 15:20
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "会员登录")
public class MemberLoginLogDTO extends BaseIdDTO<Long> {
    @Serial
    private static final long serialVersionUID = 3462553036699905215L;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "会员用户id")
    private Long memberId;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "会员用户名称")
    private String memberUserName;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "登录ip")
    private String ip;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "登录城市")
    private String city;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "登录来源 1.Web端 2.Android端 3.IOS端 4.PC端")
    private Integer source;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "创建时间")
    private LocalDateTime createDataTime;

}
