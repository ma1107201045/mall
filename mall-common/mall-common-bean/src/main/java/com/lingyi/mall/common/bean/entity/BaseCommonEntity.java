package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
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
@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseCommonEntity extends BaseIdEntity {

    /**
     * 创建人
     */
    @CreatedBy
    @Column(name = "create_by", nullable = false, length = 20)
    protected String createBy;
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_date_time", nullable = false)
    protected LocalDateTime createDateTime;
    /**
     * 最后修改人
     */
    @LastModifiedBy
    @Column(name = "last_modify_by", nullable = false, length = 20)
    protected String lastModifyBy;
    /**
     * 最后修改时间
     */
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
