package com.lingyi.mall.common.base.jpa.listener;

import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.base.constant.BaseConstant;
import com.lingyi.mall.common.base.entity.BaseCommonDO;
import com.lingyi.mall.common.base.entity.BaseIsDeleteDO;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.jpa.listener.auditor.CustomAuditorAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/7 8:55
 * @description
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CustomEntityListener {


    private CustomAuditorAware<String> auditorAware;

    @PrePersist
    protected void preInsert(Object target) {
        insertHandle(target);
        setIsDelete(target);
    }


    @PreUpdate
    protected void preUpdate(Object target) {
        updateHandle(target);
    }


    private void insertHandle(Object target) {
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getCreateBy())) {
            String auditor = auditorAware.getCurrentAuditor().orElse(BaseConstant.UNKNOWN);
            baseCommonDO.setCreateBy(auditor);
            baseCommonDO.setCreateDateTime(LocalDateTime.now());
            baseCommonDO.setLastModifyBy(auditor);
            baseCommonDO.setLastModifyDateTime(LocalDateTime.now());
        }
    }

    private void updateHandle(Object target) {
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getLastModifyBy())) {
            String auditor = auditorAware.getCurrentAuditor().orElse(BaseConstant.UNKNOWN);
            baseCommonDO.setLastModifyBy(auditor);
            baseCommonDO.setLastModifyDateTime(LocalDateTime.now());
        }
    }

    private void setIsDelete(Object target) {
        if (target instanceof BaseIsDeleteDO baseIsDeleteEntity && Objects.isNull(baseIsDeleteEntity.getIsDelete())) {
            baseIsDeleteEntity.setIsDelete(WhetherEnum.N.getCode());
        }
    }
}
