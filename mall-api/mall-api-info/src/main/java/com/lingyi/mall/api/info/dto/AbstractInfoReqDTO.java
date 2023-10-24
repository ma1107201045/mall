package com.lingyi.mall.api.info.dto;

import lombok.Data;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/10/15 15:35
 * @Description:
 */
@Data
public abstract class AbstractInfoReqDTO {

    /**
     * 服务类型
     */
    private Integer serviceType;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 手机号或者邮箱
     */
    private String number;

    /**
     * 短信类型 1.短信 2.短信验证码
     */
    private Integer type;
}
