package com.lingyi.mall.biz.sms.entity;

import com.lingyi.mall.common.base.entity.BaseCommonDO;
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
}
