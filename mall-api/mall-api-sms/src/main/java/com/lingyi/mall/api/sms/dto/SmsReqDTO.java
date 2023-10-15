package com.lingyi.mall.api.sms.dto;

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
public class SmsReqDTO extends AbstractDTO {


    /**
     * 每天发送上限
     */
    private Integer upperLimit;

    /**
     * 发送间隔
     */
    private Integer interval;

    /**
     * 备注
     */
    private String remark;


}
