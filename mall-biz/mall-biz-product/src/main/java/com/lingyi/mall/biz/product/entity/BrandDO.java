package com.lingyi.mall.biz.product.entity;

import com.lingyi.mall.common.orm.entity.BaseCommonDO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "mp_brand")
@DynamicInsert
public class BrandDO extends BaseCommonDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 9200613963397364846L;
    
    @Column(name = "user_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '用户id'")
    private Long userId;

    @Column(name = "merchant_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商家id'")
    private Long merchantId;

    @Column(name = "shop_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '商铺id'")
    private Long shopId;

    @Column(name = "name", columnDefinition = "VARCHAR(50) NOT NULL COMMENT '品牌名称'")
    private String name;

    @Column(name = "logo", columnDefinition = "VARCHAR(100) NOT NULL COMMENT 'logo'")
    private String logo;

    @Column(name = "first_character", columnDefinition = "CHAR(1) DEFAULT '' COMMENT '品牌首字母'")
    private String firstCharacter;

    @Column(name = "main_pic", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '品牌主图'")
    private String mainPic;
}
