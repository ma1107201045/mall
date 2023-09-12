package com.lingyi.mall.biz.sms.service;

import com.lingyi.mall.biz.sms.dto.CaptchaLogDTO;
import com.lingyi.mall.biz.sms.entity.CaptchaLogDO;
import com.lingyi.mall.biz.sms.param.CaptchaLogParam;
import com.lingyi.mall.biz.sms.vo.CaptchaLogVO;
import com.lingyi.mall.common.orm.util.BaseService;
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
