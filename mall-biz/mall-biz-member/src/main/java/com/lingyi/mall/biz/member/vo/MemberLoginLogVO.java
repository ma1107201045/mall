package com.lingyi.mall.biz.member.vo;

import com.lingyi.mall.common.orm.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/6 9:31
 * @description
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "会员登录日志")
public class MemberLoginLogVO extends BaseIdVO<Long> {
    @Serial
    private static final long serialVersionUID = 7377826145663382737L;


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
