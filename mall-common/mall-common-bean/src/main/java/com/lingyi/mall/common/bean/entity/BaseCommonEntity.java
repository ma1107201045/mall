package com.lingyi.mall.common.bean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:44
 * @description
 */

@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseCommonEntity extends BaseIdEntity {


    @Schema(description = "创建人", hidden = true)
    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 20, updatable = false)
    protected String createBy;


    @Schema(description = "创建时间", hidden = true)
    @CreatedDate
    @Column(name = "create_date_time", nullable = false, updatable = false)
    protected LocalDateTime createDateTime;


    @Schema(description = "最后修改人", hidden = true)
    @LastModifiedBy
    @Column(name = "last_modify_by", nullable = false, length = 20)
    protected String lastModifyBy;


    @Schema(description = "最后修改时间", hidden = true)
    @LastModifiedDate
    @Column(name = "last_modify_date_time", nullable = false)
    protected LocalDateTime lastModifyDateTime;

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
        BaseCommonEntity that = (BaseCommonEntity) o;
        if (!Objects.equals(createBy, that.createBy)) {
            return false;
        }
        if (!Objects.equals(createDateTime, that.createDateTime)) {
            return false;
        }
        if (!Objects.equals(lastModifyBy, that.lastModifyBy)) {
            return false;
        }
        return Objects.equals(lastModifyDateTime, that.lastModifyDateTime);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDateTime != null ? createDateTime.hashCode() : 0);
        result = 31 * result + (lastModifyBy != null ? lastModifyBy.hashCode() : 0);
        result = 31 * result + (lastModifyDateTime != null ? lastModifyDateTime.hashCode() : 0);
        return result;
    }
}
