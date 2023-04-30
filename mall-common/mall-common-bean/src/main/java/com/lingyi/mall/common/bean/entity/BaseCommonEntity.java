package com.lingyi.mall.common.bean.entity;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/4/30 13:44
 * @description
 */
public abstract class BaseCommonEntity extends BaseIdEntity {
    @Serial
    private static final long serialVersionUID = 1527566468186021632L;
    /**
     * 创建人
     */
    @CreatedBy
    @Column(length = 10)
    private String createBy;
    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createDateTime;
    /**
     * 最后修改人
     */
    @LastModifiedBy
    @Column(length = 10)
    private String lastModifyBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifyDateTime;

}
