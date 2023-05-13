package com.lingyi.mall.api.system.b.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lingyi.mall.common.bean.entity.BaseIsDeleteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-用户表
 */
@Schema(description = "用户")
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbs_user")
public class User extends BaseIsDeleteEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5771438753938667975L;

    @Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "用户名称不能为空")
    @Size(min = 1, max = 20, message = "用户名称长度只能在1到20之间")
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;


    @Schema(description = "真实姓名")
    @Size(min = 1, max = 20, message = "真实姓名长度只能在1到20之间")
    @Column(name = "real_name", length = 20)
    private String realName;


    @Schema(description = "昵称")
    @JsonIgnore
    @Column(name = "nickname", length = 20)
    private String nickname;


    @Schema(description = "性别 1 男 2 女")
    @Column(name = "sex", length = 4)
    private Integer sex;


    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "密码不能为空")
    @Column(name = "password", nullable = false, length = 200)
    private String password;


    @Schema(description = "头像")
    @Column(name = "head_portrait", length = 100)
    private String headPortrait;


    @Schema(description = "邮箱")
    @Size(max = 20)
    @Column(name = "email", length = 20)
    private String email;


    @Schema(description = "手机号")
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;


    @Schema(description = "最后登录IP")
    @Size(max = 30)
    @Column(name = "last_login_ip", length = 30)
    private String lastLoginIp;


    @Schema(description = "最后登录时间")
    @Column(name = "last_login_date_time")
    private LocalDateTime lastLoginDateTime;


    @Schema(description = "是否启用 1 是 0 否", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    @Column(name = "is_enable", nullable = false, length = 4)
    private Integer isEnable;


    @Schema(description = "备注")
    @Column(name = "remark")
    private String remark;


    @Schema(description = "角色集", hidden = true)
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    @ToString.Exclude
    private List<Role> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        User user = (User) o;

        if (!Objects.equals(userName, user.userName)) {
            return false;
        }
        if (!Objects.equals(realName, user.realName)) {
            return false;
        }
        if (!Objects.equals(nickname, user.nickname)) {
            return false;
        }
        if (!Objects.equals(sex, user.sex)) {
            return false;
        }
        if (!Objects.equals(password, user.password)) {
            return false;
        }
        if (!Objects.equals(headPortrait, user.headPortrait)) {
            return false;
        }
        if (!Objects.equals(email, user.email)) {
            return false;
        }
        if (!Objects.equals(phoneNumber, user.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(lastLoginIp, user.lastLoginIp)) {
            return false;
        }
        if (!Objects.equals(lastLoginDateTime, user.lastLoginDateTime)) {
            return false;
        }
        if (!Objects.equals(isEnable, user.isEnable)) {
            return false;
        }
        if (!Objects.equals(remark, user.remark)) {
            return false;
        }
        return Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (headPortrait != null ? headPortrait.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (lastLoginDateTime != null ? lastLoginDateTime.hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}