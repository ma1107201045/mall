package com.lingyi.mall.common.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:49
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public abstract class BaseIsDeleteDO extends BaseCommonDO {

    @Column(name = "is_delete", columnDefinition = "TINYINT(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0否'")
    protected Integer isDelete;

}
