package com.lingyi.mall.biz.system.vo;

import com.lingyi.mall.common.orm.vo.BaseIdVO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/9/10 20:34
 * @Description:
 */
@Schema(description = "日志")
public class LogVO extends BaseIdVO<Long> {

    @Serial
    private static final long serialVersionUID = 3268364725290785326L;

    @Schema(description = "标题")
    private String title;
    @Schema(description = "操作类型 1.创建 2.删除 3.更改 4.读取 5.其他")
    private Integer operationType;
    @Schema(description = "调用类名")
    private String callClass;

    @Schema(description = "调用类方法")
    private String callClassMethod;

    @Schema(description = "请求参数")
    private String requestParam;

    @Schema(description = "返回参数")
    private String responseParam;

    @Schema(description = "执行时长 单位ms")
    private Long executeDuration;

    @Schema(description = "执行结果 1 成功 0 失败")
    private Integer executeResult;

    @Schema(description = "失败原因")
    private String failReason;
    @Schema(description = "客户端ip")
    private String clientIp;

    @Schema(description = "备注")
    private String remark;
    @Schema(description = "创建人")
    private String createBy;
    @Schema(description = "创建时间")
    private LocalDateTime createDateTime;

}
