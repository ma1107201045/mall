package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.entity.SmsLogDO;
import com.lingyi.mall.biz.sms.mapper.SmsLogMapper;
import com.lingyi.mall.biz.sms.repositroy.SmsLogRepository;
import com.lingyi.mall.biz.sms.service.SmsLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
@RequiredArgsConstructor
public class SmsLogServiceImpl implements SmsLogService {

    private final SmsLogRepository smsLogRepository;

    private final SmsLogMapper smsLogMapper;

    @Override
    public void create(SmsLogDO smsLogDO) {

    }
}
