package com.lingyi.mall.biz.system.entity;

import com.lingyi.mall.common.jdbc.entity.BaseCommonDO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:04
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "ms_log")
@DynamicInsert
public class LogDO extends BaseCommonDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3263673947812164534L;

    @Column(name = "title", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '标题'")
    private String title;

    @Column(name = "operation_type", columnDefinition = "TINYINT(4) DEFAULT NULL COMMENT '操作类型 1.创建 2.删除 3.更改 4.读取 5.其他'")
    private Integer operationType;

    @Column(name = "call_class", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '调用类名'")
    private String callClass;

    @Column(name = "call_class_method", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '调用类方法'")
    private String callClassMethod;

    @Column(name = "request_param", columnDefinition = "TEXT  COMMENT '请求参数'")
    private String requestParam;

    @Column(name = "response_param", columnDefinition = "LONGTEXT COMMENT '返回参数'")
    private String responseParam;

    @Column(name = "execute_duration", columnDefinition = "BIGINT(20) UNSIGNED DEFAULT NULL COMMENT '执行时长 单位ms'")
    private Long executeDuration;

    @Column(name = "execute_result", columnDefinition = "TINYINT(4) DEFAULT 1 COMMENT '执行结果 1 成功 0 失败'")
    private Integer executeResult;

    @Column(name = "fail_reason", columnDefinition = "TEXT COMMENT '失败原因'")
    private String failReason;

    @Column(name = "client_ip", columnDefinition = "VARCHAR(20) DEFAULT '' COMMENT '客户端ip'")
    private String clientIp;

    @Column(name = "remark", columnDefinition = "VARCHAR(200) DEFAULT '' COMMENT '备注'")
    private String remark;

}
