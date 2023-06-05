package com.lingyi.mall.common.base.jpa.listener;

import com.lingyi.mall.common.base.entity.BaseIsDeleteEntity;
import com.lingyi.mall.common.base.enums.YN;
import jakarta.annotation.Resource;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/20 2:23
 * @Description:
 */
@Configurable
public class CustomAuditingEntityListener {

    @Resource
    private AuditingEntityListener auditingEntityListener;

    @PrePersist
    public void touchForCreate(Object target) {
        auditingEntityListener.touchForCreate(target);
        setIsDelete(target);
    }


    @PreUpdate
    public void touchForUpdate(Object target) {
        auditingEntityListener.touchForUpdate(target);
        setIsDelete(target);
    }

    private void setIsDelete(Object target) {
        if (target instanceof BaseIsDeleteEntity baseIsDeleteEntity && Objects.isNull(baseIsDeleteEntity.getIsDelete())) {
            baseIsDeleteEntity.setIsDelete(YN.N.getCode());
        }
    }
}
