package com.lingyi.mall.biz.sms.entity;

import com.lingyi.mall.common.base.entity.BaseCommonDO;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "ms_sms_log")
@DynamicInsert
public class SmsLogDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5605276090951019486L;

    @Column(name = "service_name", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '服务名称'")
    private String serviceName;

    @Column(name = "business_name", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '业务名称'")
    private String businessName;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '手机号'")
    private String phoneNumber;

    @Column(name = "captcha", columnDefinition = "VARCHAR(10) NOT NULL COMMENT '验证码'")
    private String captcha;

    @Column(name = "captcha_length", columnDefinition = "INT UNSIGNED NOT NULL COMMENT '验证码长度'")
    private Integer captchaLength;

    @Column(name = "is_success", columnDefinition = "INT UNSIGNED NOT NULL  COMMENT '是否成功 1.是 0.否'")
    private Integer isSuccess;

    @Column(name = "fail_message", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '失败信息'")
    private String failMessage;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;

}
