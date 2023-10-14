package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.model.dto.SmsLogDTO;
import com.lingyi.mall.biz.sms.model.entity.SmsLogDO;
import com.lingyi.mall.biz.sms.dao.mapper.SmsLogMapper;
import com.lingyi.mall.biz.sms.model.param.SmsLogParam;
import com.lingyi.mall.biz.sms.dao.repositroy.SmsLogRepository;
import com.lingyi.mall.biz.sms.service.SendLogService;
import com.lingyi.mall.biz.sms.model.vo.SmsLogVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
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
public class SendLogServiceImpl extends BaseServiceProImpl<SmsLogRepository, SmsLogMapper, SmsLogDTO, SmsLogVO, SmsLogParam, SmsLogDO, Long> implements SendLogService {


}
