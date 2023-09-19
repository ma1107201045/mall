package com.lingyi.mall.common.orm.jpa.listener;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.lingyi.mall.common.core.constant.BaseConstant;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import com.lingyi.mall.common.orm.entity.BaseIsDeleteDO;
import com.lingyi.mall.common.core.util.CustomAuditorAware;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getCreateBy())) {
            var auditor = auditorAware.getCurrentAuditor().orElse(BaseConstant.UNKNOWN);
            baseCommonDO.setCreateBy(auditor);
            baseCommonDO.setCreateDateTime(LocalDateTime.now());
            baseCommonDO.setLastModifyBy(auditor);
            baseCommonDO.setLastModifyDateTime(LocalDateTime.now());
        }
        if (target instanceof BaseIsDeleteDO baseIsDeleteEntity && Objects.isNull(baseIsDeleteEntity.getIsDelete())) {
            baseIsDeleteEntity.setIsDelete(WhetherEnum.N.getCode());
        }
        //临时逻辑,后期优化
        if (ReflectUtil.hasField(target.getClass(), "merchantId")) {
            ReflectUtil.setFieldValue(target, "merchantId", 1L);
        }
        if (ReflectUtil.hasField(target.getClass(), "shopId")) {
            ReflectUtil.setFieldValue(target, "shopId", 1L);
        }
        if (ReflectUtil.hasField(target.getClass(), "userId")) {
            Object userId = ReflectUtil.getFieldValue(target, "userId");
            if (Objects.isNull(userId)) {
                ReflectUtil.setFieldValue(target, "userId", 1L);
            }
        }
    }


    @PreUpdate
    protected void preUpdate(Object target) {
        if (target instanceof BaseCommonDO baseCommonDO && StrUtil.isBlank(baseCommonDO.getLastModifyBy())) {
            var auditor = auditorAware.getCurrentAuditor().orElse(BaseConstant.UNKNOWN);
            baseCommonDO.setLastModifyBy(auditor);
            baseCommonDO.setLastModifyDateTime(LocalDateTime.now());
        }
    }
}
