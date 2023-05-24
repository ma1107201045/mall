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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/24 14:49
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbm_member")
public class Member extends BaseIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2724268672754765122L;
    /**
     * 会员等级id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_level_id", nullable = false)
    @ToString.Exclude
    private MemberLevel memberLevel;

    /**
     * 用户名称
     */
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "nickname", length = 20)
    private String nickname;

    /**
     * 性别 1 男 2 女
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private LocalDate birthday;

    /**
     * 手机号
     */
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    /**
     * 头像
     */
    @Column(name = "head_portrait", length = 200)
    private String headPortrait;

    /**
     * 头像
     */
    @Column(name = "personalized_signature", length = 200)
    private String personalizedSignature;

    /**
     * 是否启用 1 是 0 否
     */
    @Column(name = "is_enable", nullable = false)
    private Integer isEnable;

    /**
     * 注册来源 1.Web端 2.Android端 3.IOS端 4.PC端
     */
    @Column(name = "register_source", nullable = false)
    private Integer registerSource;


    /**
     * 注册时间
     */
    @Column(name = "register_data_time", nullable = false)
    private LocalDateTime registerDataTime;
}
