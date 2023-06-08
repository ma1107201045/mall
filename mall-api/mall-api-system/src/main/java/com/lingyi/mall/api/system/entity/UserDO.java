package com.lingyi.mall.api.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
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
@Table(name = "ms_user", uniqueConstraints = @UniqueConstraint(name = "uk_user_name", columnNames = "user_name"))
public class UserDO extends BaseIsDeleteDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5771438753938667975L;

    @Column(name = "user_name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '用户名称'")
    private String userName;

    @Column(name = "real_name", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '真实姓名'")
    private String realName;

    @Column(name = "nickname", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '昵称'")
    private String nickname;

    @Column(name = "sex", columnDefinition = "TINYINT(4) UNSIGNED DEFAULT NULL COMMENT '性别 1 男 2 女'")
    private Integer sex;

    @JsonIgnore
    @Column(name = "password", columnDefinition = "VARCHAR(100) NOT NULL COMMENT '密码'")
    private String password;

    @Column(name = "head_portrait", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '密码'")
    private String headPortrait;

    @Schema(description = "邮箱")
    @Column(name = "email", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '邮箱'")
    private String email;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '手机号'")
    private String phoneNumber;

    @Column(name = "last_login_ip", columnDefinition = "INT(30) COMMENT '手机号'")
    private String lastLoginIp;

    @Column(name = "is_enable", columnDefinition = "TINYINT(4) NOT NULL COMMENT '是否启用 1 是 0 否'")
    private Integer isEnable;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;
    /**
     * 角色集
     */
    @ManyToMany(mappedBy = "users")
    private List<RoleDO> roles;


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

        UserDO userDO = (UserDO) o;

        if (!Objects.equals(userName, userDO.userName)) {
            return false;
        }
        if (!Objects.equals(realName, userDO.realName)) {
            return false;
        }
        if (!Objects.equals(nickname, userDO.nickname)) {
            return false;
        }
        if (!Objects.equals(sex, userDO.sex)) {
            return false;
        }
        if (!Objects.equals(password, userDO.password)) {
            return false;
        }
        if (!Objects.equals(headPortrait, userDO.headPortrait)) {
            return false;
        }
        if (!Objects.equals(email, userDO.email)) {
            return false;
        }
        if (!Objects.equals(phoneNumber, userDO.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(lastLoginIp, userDO.lastLoginIp)) {
            return false;
        }
        if (!Objects.equals(isEnable, userDO.isEnable)) {
            return false;
        }
        if (!Objects.equals(remark, userDO.remark)) {
            return false;
        }
        return Objects.equals(roles, userDO.roles);
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
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}