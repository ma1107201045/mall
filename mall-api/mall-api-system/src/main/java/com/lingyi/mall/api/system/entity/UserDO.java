package com.lingyi.mall.api.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description 系统管理-用户表
 */
@Schema(description = "用户")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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

}