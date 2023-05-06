package com.lingyi.mall.common.bean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:38
 * @description
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
@FieldNameConstants
@MappedSuperclass
public abstract class BaseIdEntity {


    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Id
    @GeneratedValue(generator = "SnowflakeIdentifierGenerator")
    @GenericGenerator(name = "SnowflakeIdentifierGenerator", strategy = "com.lingyi.mall.common.fill.jpa.generator.SnowflakeIdentifierGenerator")
    @Column(name = "id", nullable = false, length = 20)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseIdEntity that = (BaseIdEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
