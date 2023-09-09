package com.lingyi.mall.biz.member.entity;

import com.lingyi.mall.common.jdbc.entity.BaseIdDO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 15:21
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mm_member_login_log")
@DynamicInsert
public class MemberLoginLogDO extends BaseIdDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7083829914819620788L;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false, foreignKey = @ForeignKey(name = "fk_member_id"))
    private MemberDO memberDO;

    @Column(name = "member_user_name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '会员用户名称'")
    private String memberUserName;

    @Column(name = "ip", length = 20, columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '登录ip'")
    private String ip;

    @Column(name = "city", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '登录城市'")
    private String city;

    @Column(name = "source", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '登录来源 1.Web端 2.Android端 3.IOS端 4.PC端")
    private Integer source;

    @Column(name = "create_data_time", columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    private LocalDateTime createDataTime;
}
