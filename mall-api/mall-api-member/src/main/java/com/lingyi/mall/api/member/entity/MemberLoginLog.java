package com.lingyi.mall.api.member.entity;

import com.lingyi.mall.common.base.entity.BaseIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 15:21
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbm_member_login_log")
public class MemberLoginLog extends BaseIdEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 7083829914819620788L;

    /**
     * 会员id
     */
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    @ToString.Exclude
    private Member member;

    /**
     * 会员用户名称
     */
    @Column(name = "member_user_name", nullable = false, length = 20)
    private String memberUserName;
    /**
     * 登录ip
     */
    @Column(name = "ip", length = 20)
    private String ip;

    /**
     * 登录所在城市
     */
    @Column(name = "city", length = 20)
    private String city;

    /**
     * 登录来源 1.Web端 2.Android端 3.IOS端 4.PC端
     */
    @Column(name = "source")
    private Integer source;

    /**
     * 创建时间
     */
    @Column(name = "create_data_time")
    private LocalDateTime createDataTime;
}
