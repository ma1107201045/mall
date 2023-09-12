package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.dto.CaptchaLogDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.enums.SmsFailEnum;
import com.lingyi.mall.biz.sms.mapper.CaptchaLogMapper;
import com.lingyi.mall.biz.sms.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.repositroy.CaptchaLogRepository;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.biz.sms.vo.CaptchaLogVO;
import com.lingyi.mall.common.core.util.AssertUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
@RequiredArgsConstructor
public class CaptchaLogServiceImpl extends BaseServiceProImpl<CaptchaLogRepository, CaptchaLogMapper, CaptchaLogDTO, CaptchaLogVO, CaptchaLogParam, CaptchaLogDO, Long> implements CaptchaLogService {


}
