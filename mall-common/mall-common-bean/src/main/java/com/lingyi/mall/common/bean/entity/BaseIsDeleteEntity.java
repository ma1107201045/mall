package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;

import java.io.Serial;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:49
 * @description
 */
public abstract class BaseIsDeleteEntity extends BaseCommonEntity {
    @Serial
    private static final long serialVersionUID = -2047585741010388531L;


    /**
     * 是否删除 1 是 0 否
     */
    @Column(length = 4)
    private Integer isDelete;
}
