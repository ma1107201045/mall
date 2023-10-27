package com.lingyi.mall.api.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/8/17 14:21
 * @description
 */
@Data
@Schema(description = "会员登录日志")
public class MemberLoginLogReqDTO {

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
