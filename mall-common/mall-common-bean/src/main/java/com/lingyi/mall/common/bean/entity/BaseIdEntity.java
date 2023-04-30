package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:38
 * @description
 */
public abstract class BaseIdEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3154728442401869777L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "com.lingyi.mall.common.dao.jpa.generator.CustomIdentifierGenerator")
    @Column(length = 20)
    private Long id;
}
