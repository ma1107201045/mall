package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.api.sms.dto.SmsReqDTO;
import com.lingyi.mall.biz.sms.service.SmsService;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:22
 * @description
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(SmsReqDTO smsReqDTO) {
        //TODO 发送mq消息

    }
}
