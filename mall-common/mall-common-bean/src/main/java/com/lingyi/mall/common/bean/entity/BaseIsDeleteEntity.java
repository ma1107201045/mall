package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:49
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@FieldNameConstants
@MappedSuperclass
public abstract class BaseIsDeleteEntity extends BaseCommonEntity {

    /**
     * 是否删除 1 是 0 否
     */
    @Column(name = "is_delete", length = 4)
    protected Integer isDelete;

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
        BaseIsDeleteEntity that = (BaseIsDeleteEntity) o;
        return Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }
}
