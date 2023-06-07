package com.lingyi.mall.common.base.entity;

import com.lingyi.mall.common.base.jpa.listener.CustomAuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class)
public abstract class BaseCommonDO extends BaseIdDO {


    @CreatedBy
    @Column(name = "create_by", updatable = false, columnDefinition = "varchar(20) NOT NULL COMMENT '创建人'")
    protected String createBy;

    @CreatedDate
    @Column(name = "create_date_time", updatable = false, columnDefinition = "datetime(6) NOT NULL COMMENT '创建时间'")
    protected LocalDateTime createDateTime;

    @LastModifiedBy
    @Column(name = "last_modify_by", columnDefinition = "varchar(20) NOT NULL COMMENT '最后修改人'")
    protected String lastModifyBy;

    @LastModifiedDate
    @Column(name = "last_modify_date_time", columnDefinition = "datetime(6) NOT NULL COMMENT '最后修改时间'")
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
        BaseCommonDO that = (BaseCommonDO) o;
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
