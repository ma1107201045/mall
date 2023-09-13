package com.lingyi.mall.common.orm.entity;

import com.lingyi.mall.common.orm.jpa.generator.SnowflakeIdentifierGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:38
 * @description
 */
@Data
@MappedSuperclass
public abstract class BaseIdDO<ID extends Serializable> {


    @Id
    @GeneratedValue(generator = "SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "SnowflakeIdentifierGenerator", type = SnowflakeIdentifierGenerator.class)
    @Column(name = "id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '主键id'")
    protected ID id;

}
