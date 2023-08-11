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
import java.math.BigInteger;

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

    @Column(name = "service_name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '服务名称'")
    private String serviceName;

    @Column(name = "business_name", columnDefinition = "VARCHAR(50) NOT NULL COMMENT '业务名称'")
    private String businessName;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '手机号'")
    private String phoneNumber;

    @Column(name = "captcha", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '验证码'")
    private Integer captcha;

    @Column(name = "length", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码长度'")
    private Integer length;

    @Column(name = "expiry_date", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码有效期 （分钟）'")
    private Integer expiryDate;

    @Column(name = "interval_date", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码发送间隔时间（分钟）'")
    private Integer intervalDate;

    @Column(name = "upper_limit", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码每天上限'")
    private Integer upperLimit;

    @Column(name = "is_success", columnDefinition = "INT UNSIGNED COMMENT '是否成功 1.是 0.否'")
    private Integer isSuccess;

    @Column(name = "fail_message", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '失败信息'")
    private String failMessage;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;

}
