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
 * @datetime 2023/5/24 14:53
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "mbm_member_level")
public class MemberLevel extends BaseIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1698976479509049883L;
}
