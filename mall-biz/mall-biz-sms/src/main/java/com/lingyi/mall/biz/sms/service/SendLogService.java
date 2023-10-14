package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.biz.sms.model.dto.SmsLogDTO;
import com.lingyi.mall.biz.sms.model.entity.SmsLogDO;
import com.lingyi.mall.biz.sms.model.param.SmsLogParam;
import com.lingyi.mall.biz.sms.model.vo.SmsLogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
public interface SendLogService extends BaseServicePro<SmsLogDTO, SmsLogVO, SmsLogParam, SmsLogDO, Long> {


}
