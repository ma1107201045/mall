
package com.lingyi.mall.biz.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lingyi.mall.common.core.jackson.serializer.ChineseNameSerialize;
import com.lingyi.mall.common.core.jackson.serializer.EmailSerialize;
import com.lingyi.mall.common.core.jackson.serializer.Ipv4Serializer;
import com.lingyi.mall.common.core.jackson.serializer.PhoneNumberSerialize;
import com.lingyi.mall.common.core.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 21:32
 * @Description:
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户")
public class UserVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = -5501894157954555575L;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "真实姓名")
    @JsonSerialize(using = ChineseNameSerialize.class)
    private String realName;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别 1 男 2 女")
    private Integer sex;

    @Schema(description = "密码")
    @JsonIgnore
    private String password;

    @Schema(description = "头像")
    private String headPortrait;

    @Schema(description = "邮箱")
    @JsonSerialize(using = EmailSerialize.class)
    private String email;

    @Schema(description = "手机号")
    @JsonSerialize(using = PhoneNumberSerialize.class)
    private String phoneNumber;

    @Schema(description = "最后登录IP")
    @JsonSerialize(using = Ipv4Serializer.class)
    private String lastLoginIp;

    @Schema(description = "是否启用 1 是 0 否")
    private Integer isEnable;

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

    @Schema(description = "角色id集")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> roleIds;

    @Schema(description = "按钮权限标识集")
    private List<String> permissions;
}
