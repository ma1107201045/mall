package com.lingyi.mall.common.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingyi.mall.common.base.jpa.listener.CustomAuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

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
@EntityListeners(CustomAuditingEntityListener.class)
public abstract class BaseCommonDO extends BaseIdDO {


    @CreatedBy
    @Column(name = "create_by", updatable = false, columnDefinition = "VARCHAR(20) NOT NULL COMMENT '创建人'")
    protected String createBy;

    @CreatedDate
    @Column(name = "create_date_time", updatable = false, columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createDateTime;

    @LastModifiedBy
    @Column(name = "last_modify_by", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '最后修改人'")
    protected String lastModifyBy;

    @LastModifiedDate
    @Column(name = "last_modify_date_time", columnDefinition = "DATETIME NOT NULL COMMENT '最后修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime lastModifyDateTime;

}
