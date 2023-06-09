package com.lingyi.mall.api.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:47
 * @description
 */
@Schema(description = "会员")
@Data
public class MemberReqDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6855300415860050264L;

    @Schema(description = "会员id")
    private Long memberId;

    @Schema(description = "会员等级id")
    private Long memberLevelId;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别：1 男；2 女")
    private Integer sex;

    @Schema(description = "生日")
    private LocalDate birthday;

    @Schema(description = "手机号码")
    private String phoneNumber;

    @Schema(description = "头像")
    private String headPortrait;

    @Schema(description = "个性签名")
    private String personalizedSignature;

    @Schema(description = "是否启用 1 是 0 否")
    private Integer isEnable;

    @Schema(description = "注册来源 1.Web端 2.Android端 3.IOS端 4.PC端")
    private Integer registerSource;

    @Schema(description = "注册时间")
    private LocalDateTime registerDataTime;
}
