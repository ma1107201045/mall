package com.lingyi.mall.common.base.entity;

import com.lingyi.mall.common.base.jpa.listener.CustomAuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:49
 * @description
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseIsDeleteEntity extends BaseCommonEntity {


    @Column(name = "is_delete", nullable = false, length = 4)
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