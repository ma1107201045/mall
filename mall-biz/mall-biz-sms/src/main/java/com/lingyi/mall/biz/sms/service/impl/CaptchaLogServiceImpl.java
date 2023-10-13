package com.lingyi.mall.biz.sms.service.impl;

import com.lingyi.mall.biz.sms.model.dto.CaptchaLogDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.dao.mapper.CaptchaLogMapper;
import com.lingyi.mall.biz.sms.model.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.dao.repositroy.CaptchaLogRepository;
import com.lingyi.mall.biz.sms.service.CaptchaLogService;
import com.lingyi.mall.biz.sms.model.vo.CaptchaLogVO;
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
public class CaptchaLogServiceImpl extends BaseServiceProImpl<CaptchaLogRepository, CaptchaLogMapper, CaptchaLogDTO, CaptchaLogVO, CaptchaLogParam, CaptchaLogDO, Long> implements CaptchaLogService {


}
