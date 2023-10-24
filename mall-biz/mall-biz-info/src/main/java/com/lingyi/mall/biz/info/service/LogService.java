package com.lingyi.mall.biz.info.service;

import com.lingyi.mall.biz.info.model.dto.LogDTO;
import com.lingyi.mall.biz.info.model.entity.LogDO;
import com.lingyi.mall.biz.info.model.param.LogParam;
import com.lingyi.mall.biz.info.model.vo.LogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 14:19
 * @description
 */
@Service
public interface LogService extends BaseServicePro<LogDTO, LogVO, LogParam, LogDO, Long> {

}
