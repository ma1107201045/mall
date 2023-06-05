package com.lingyi.mall.api.system.entity;

import com.lingyi.mall.common.base.entity.BaseCommonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
@DynamicInsert
@Entity
@Table(name = "mbs_log")
public class Log extends BaseCommonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3263673947812164534L;

    /**
     * 标题
     */
    @Column(name = "title", length = 200)
    private String title;

    /**
     * 操作类型 1.创建 2.删除 3.更改 4.读取 5.其他
     */
    @Column(name = "operation_type")
    private Integer operationType;

    /**
     * 调用类名
     */
    @Column(name = "call_class", length = 100)
    private String callClass;

    /**
     * 调用方法
     */
    @Column(name = "call_method", length = 100)
    private String callMethod;

    /**
     * 请求参数
     */
    @Column(name = "request_param", length = 200)
    private String requestParam;
    /**
     * 返回参数
     */
    @Column(name = "response_param", length = 200)
    private String responseParam;

    /**
     * 执行时长 单位ms
     */
    @Column(name = "execute_duration")
    private Long executeDuration;

    /**
     * 执行结果 1 成功 0 失败
     */
    @Column(name = "execute_result")
    private Integer executeResult;

    /**
     * 失败原因
     */
    @Column(name = "fail_reason", length = 200)
    private String failReason;

    /**
     * 客户端ip
     */
    @Column(name = "client_ip", length = 20)
    private String clientIp;
    /**
     * 备注
     */
    @Column(name = "remark", length = 200)
    private String remark;

}
