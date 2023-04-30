package com.lingyi.mall.biz.system.entity;

import com.lingyi.mall.common.bean.entity.BaseIsDeleteEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 22:43
 * @description
 */
@Getter
@Setter
@Entity
@Table(name = "mbs_user")
public class MbsUser extends BaseIsDeleteEntity {
    @Serial
    private static final long serialVersionUID = -6359019185255171156L;

    /**
     * 用户名称
     */
    @Column(name = "user_name", nullable = false, length = 10)
    private String userName;

    /**
     * 真实姓名
     */
    @Column(name = "real_name", length = 10)
    private String realName;

    /**
     * 昵称
     */
    @Column(name = "nickname", length = 10)
    private String nickname;

    /**
     * 性别 1 男 2 女
     */
    @Column(name = "sex", columnDefinition = "TINYINT UNSIGNED")
    private Integer sex;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    /**
     * 头像
     */
    @Column(name = "head_portrait", length = 100)
    private String headPortrait;

    /**
     * 邮箱
     */
    @Size(max = 20)
    @Column(name = "email", length = 20)
    private String email;

    /**
     * 手机号
     */
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    /**
     * 最后登录IP
     */
    @Size(max = 30)
    @Column(name = "last_login_ip", length = 30)
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_date_time")
    private LocalDateTime lastLoginDateTime;

    /**
     * 是否启用 1 是 0 否
     */
    @Column(name = "is_enable", columnDefinition = "TINYINT UNSIGNED not null")
    private Integer isEnable;

    /**
     * 备注
     */
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;

    /**
     * 角色集
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<MbsRole> mbsRoles;


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

        MbsUser mbsUser = (MbsUser) o;

        if (!Objects.equals(userName, mbsUser.userName)) {
            return false;
        }
        if (!Objects.equals(realName, mbsUser.realName)) {
            return false;
        }
        if (!Objects.equals(nickname, mbsUser.nickname)) {
            return false;
        }
        if (!Objects.equals(sex, mbsUser.sex)) {
            return false;
        }
        if (!Objects.equals(password, mbsUser.password)) {
            return false;
        }
        if (!Objects.equals(headPortrait, mbsUser.headPortrait)) {
            return false;
        }
        if (!Objects.equals(email, mbsUser.email)) {
            return false;
        }
        if (!Objects.equals(phoneNumber, mbsUser.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(lastLoginIp, mbsUser.lastLoginIp)) {
            return false;
        }
        if (!Objects.equals(lastLoginDateTime, mbsUser.lastLoginDateTime)) {
            return false;
        }
        if (!Objects.equals(isEnable, mbsUser.isEnable)) {
            return false;
        }
        if (!Objects.equals(remark, mbsUser.remark)) {
            return false;
        }
        return Objects.equals(mbsRoles, mbsUser.mbsRoles);
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
        result = 31 * result + (mbsRoles != null ? mbsRoles.hashCode() : 0);
        return result;
    }
}