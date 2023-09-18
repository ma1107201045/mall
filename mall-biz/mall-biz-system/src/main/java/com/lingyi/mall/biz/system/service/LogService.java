package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.param.LogParam;
import com.lingyi.mall.biz.system.vo.LogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:32
 * @description
 */
public interface LogService extends BaseServicePro<LogReqDTO, LogVO, LogParam, LogDO, Long> {


}
