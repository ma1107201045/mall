package com.lingyi.mall.biz.sms.entity;

import com.lingyi.mall.common.base.entity.BaseCommonDO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 11:12
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ms_captcha_log")
@DynamicInsert
public class CaptchaLogDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5605276090951019486L;

    @Column(name = "service_type", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '服务类型'")
    private String serviceType;

    @Column(name = "business_type", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '业务类型'")
    private String businessType;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '手机号'")
    private String phoneNumber;

    @Column(name = "length", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码长度'")
    private Integer length;

    @Column(name = "value", columnDefinition = "VARCHAR(10) NOT NULL COMMENT '验证码值'")
    private String value;

    @Column(name = "is_success", columnDefinition = "INT UNSIGNED NOT NULL  COMMENT '是否成功 1.是 0.否'")
    private Integer isSuccess;

    @Column(name = "fail_message", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '失败信息'")
    private String failMessage;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;

}
