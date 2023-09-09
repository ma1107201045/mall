package com.lingyi.mall.common.jdbc.entity;

import com.lingyi.mall.common.jdbc.jpa.generator.SnowflakeIdentifierGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:38
 * @description
 */
@Data
@MappedSuperclass
public abstract class BaseIdDO {


    @Id
    @GeneratedValue(generator = "SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "SnowflakeIdentifierGenerator", type = SnowflakeIdentifierGenerator.class)
    @Column(name = "id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '主键id'")
    protected Long id;

}
