package com.lingyi.mall.common.base.jpa.listener;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.base.entity.BaseCommonDO;
import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import com.lingyi.mall.common.base.enums.WhetherEnum;
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
        setCreateBy(target);
        setIsDelete(target);
    }


    @PreUpdate
    public void touchForUpdate(Object target) {
        setLastModifyBy(target);
        setIsDelete(target);
    }

    private void setCreateBy(Object target) {
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getCreateBy())) {
            auditingEntityListener.touchForCreate(target);
        }
    }

    private void setLastModifyBy(Object target) {
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getLastModifyBy())) {
            auditingEntityListener.touchForUpdate(target);
        }
    }

    private void setIsDelete(Object target) {
        if (target instanceof BaseIsDeleteDO baseIsDeleteEntity && Objects.isNull(baseIsDeleteEntity.getIsDelete())) {
            baseIsDeleteEntity.setIsDelete(WhetherEnum.N.getCode());
        }
    }
}
