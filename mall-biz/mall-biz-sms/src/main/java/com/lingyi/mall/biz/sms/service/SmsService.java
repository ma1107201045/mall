package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.biz.sms.dto.SmsDTO;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
public interface SmsService {


    void send(SmsDTO smsDTO);

}
