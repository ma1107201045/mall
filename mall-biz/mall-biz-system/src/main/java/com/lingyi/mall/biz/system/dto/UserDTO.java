package com.lingyi.mall.biz.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/14 19:11
 * @Description:
 */
@Schema(description = "用户")
@Data
public class UserDTO  implements Serializable{

    @Serial
    private static final long serialVersionUID = 6172702298178663383L;

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "用户名称不能为空")
    private String userName;


    @Schema(description = "真实姓名")
    private String realName;


    @Schema(description = "昵称")
    private String nickname;


    @Schema(description = "性别 1 男 2 女")
    private Integer sex;


    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "密码不能为空")
    private String password;


    @Schema(description = "头像")
    private String headPortrait;


    @Schema(description = "邮箱")
    private String email;


    @Schema(description = "手机号")
    private String phoneNumber;


    @Schema(description = "是否启用 1 是 0 否")
    @NotNull(message = "是否启用不能为空")
    private Integer isEnable;


    @Schema(description = "备注")
    private String remark;


    @Schema(description = "角色id集")
    @NotNull(message = "角色id集不能为空")
    @Size(min = 1, message = "角色id集不能为空")
    private List<Long> roleIds;
}
