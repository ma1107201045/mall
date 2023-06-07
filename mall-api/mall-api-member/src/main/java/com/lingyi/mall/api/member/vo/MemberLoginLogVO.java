package com.lingyi.mall.api.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:31
 * @description
 */
@Schema(description = "会员登录日志")
@Data
public class MemberLoginLogVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1419582644815972194L;

    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "会员id")
    private Long memberId;

    @Schema(description = "会员用户名称")
    private String memberUserName;

    @Schema(description = "登录ip")
    private String ip;

    @Schema(description = "登录所在城市")
    private String city;

    @Schema(description = " 登录来源 1.Web端 2.Android端 3.IOS端 4.PC端")
    private Integer source;

    @Schema(description = " 创建时间")
    private LocalDateTime createDataTime;
}
