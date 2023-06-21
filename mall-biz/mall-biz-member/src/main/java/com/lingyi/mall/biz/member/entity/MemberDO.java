package com.lingyi.mall.biz.member.entity;

import com.lingyi.mall.common.base.entity.BaseIdDO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:49
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mm_member", uniqueConstraints = {@UniqueConstraint(name = "uk_user_name", columnNames = "user_name"),
        @UniqueConstraint(name = "uk_phone_number", columnNames = "phone_number")})
public class MemberDO extends BaseIdDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2724268672754765122L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_level_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '会员等级id'",
            foreignKey = @ForeignKey(name = "fk_member_level_id"))
    private MemberLevelDO memberLevelDO;

    @Column(name = "user_name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '用户名称'")
    private String userName;

    @Column(name = "nickname", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '用户名称'")
    private String nickname;

    @Column(name = "sex", columnDefinition = "TINYINT(4) UNSIGNED COMMENT '性别 1 男 2 女'")
    private Integer sex;

    @Column(name = "birthday", columnDefinition = "DATE COMMENT '生日'")
    private LocalDate birthday;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '手机号'")
    private String phoneNumber;

    @Column(name = "head_portrait", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '手机号'")
    private String headPortrait;

    @Column(name = "personalized_signature", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '头像'")
    private String personalizedSignature;

    @Column(name = "is_enable", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否'")
    private Integer isEnable;

    @Column(name = "register_source", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '注册来源 1.Web端 2.Android端 3.IOS端 4.PC端'")
    private Integer registerSource;

    @Column(name = "register_data_time", columnDefinition = "DATETIME NOT NULL COMMENT '注册时间'")
    private LocalDateTime registerDataTime;

}
