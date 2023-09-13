package com.lingyi.mall.common.orm.entity;

import com.lingyi.mall.common.orm.jpa.listener.CustomEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:44
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
@EntityListeners(CustomEntityListener.class)
public abstract class BaseCommonDO extends BaseIdDO<Long> {

    @CreatedBy
    @Column(name = "create_by", updatable = false, columnDefinition = "VARCHAR(20) NOT NULL COMMENT '创建人'")
    protected String createBy;

    @CreatedDate
    @Column(name = "create_date_time", updatable = false, columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    protected LocalDateTime createDateTime;

    @LastModifiedBy
    @Column(name = "last_modify_by", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '最后修改人'")
    protected String lastModifyBy;

    @LastModifiedDate
    @Column(name = "last_modify_date_time", columnDefinition = "DATETIME NOT NULL COMMENT '最后修改时间'")
    protected LocalDateTime lastModifyDateTime;

}
