package com.lingyi.mall.api.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/9 16:35
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogReqDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8394395747897938021L;

    /**
     * 标题
     */
    private String title;
    /**
     * 操作类型 1.创建 2.删除 3.更改 4.读取 5.其他
     */
    private Integer operationType;
    /**
     * 调用类名
     */
    private String callClass;
    /**
     * 调用类方法
     */
    private String callClassMethod;
    /**
     * 请求参数
     */
    private String requestParam;
    /**
     * 返回参数
     */
    private String responseParam;
    /**
     * 执行时长 单位ms
     */
    private Long executeDuration;
    /**
     * 执行结果 1 成功 0 失败
     */
    private Integer executeResult;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 备注
     */
    private String remark;


    private String trackId;
}
