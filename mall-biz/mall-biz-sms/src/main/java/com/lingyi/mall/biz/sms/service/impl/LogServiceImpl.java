package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.model.dto.LogDTO;
import com.lingyi.mall.biz.sms.model.entity.LogDO;
import com.lingyi.mall.biz.sms.dao.mapper.SmsLogMapper;
import com.lingyi.mall.biz.sms.model.param.LogParam;
import com.lingyi.mall.biz.sms.dao.repositroy.SmsLogRepository;
import com.lingyi.mall.biz.sms.service.LogService;
import com.lingyi.mall.biz.sms.model.vo.LogVO;
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
public class LogServiceImpl extends BaseServiceProImpl<SmsLogRepository, SmsLogMapper, LogDTO, LogVO, LogParam, LogDO, Long> implements LogService {


}
