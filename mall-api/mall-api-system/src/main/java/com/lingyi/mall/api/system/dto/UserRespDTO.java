package com.lingyi.mall.api.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:10
 * @description 用户
 */
@Data
@Schema(description = "用户")
public class UserRespDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1923376838194587664L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "真实姓名")
    private String realName;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别 1 男 2 女")
    private Integer sex;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "头像")
    private String headPortrait;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String phoneNumber;

    @Schema(description = "最后登录IP")
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

    @Schema(description = " 是否删除 1是 0否")
    private Integer isDelete;

    @Schema(description = " 角色id集")
    private List<Long> roleIds;

    @Schema(description = " 按钮权限标识集")
    private List<String> permissions;
}
