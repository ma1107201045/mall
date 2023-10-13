package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.biz.sms.model.dto.CaptchaLogDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.model.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.model.vo.CaptchaLogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
public interface CaptchaLogService extends BaseServicePro<CaptchaLogDTO, CaptchaLogVO, CaptchaLogParam, CaptchaLogDO, Long> {


}
