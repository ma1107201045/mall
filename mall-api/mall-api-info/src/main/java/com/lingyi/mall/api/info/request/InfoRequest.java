package com.lingyi.mall.api.info.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/13 16:43
 * @description
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InfoRequest extends AbstractInfoRequest {


    /**
     * 发送每天上限
     */
    private Integer upperLimit;

    /**
     * 发送间隔
     */
    private Integer intervalTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;


}
