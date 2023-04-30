package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
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
@RequiredArgsConstructor
@MappedSuperclass
public abstract class BaseIdEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3154728442401869777L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "com.lingyi.mall.common.dao.jpa.generator.CustomIdentifierGenerator")
    @Column(name = "id", length = 20)
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
