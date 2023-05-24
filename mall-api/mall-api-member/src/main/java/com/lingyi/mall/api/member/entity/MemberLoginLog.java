package com.lingyi.mall.api.member.entity;

import com.lingyi.mall.common.base.entity.BaseIdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

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
}
