package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.request.LogRequest;
import com.lingyi.mall.biz.system.model.entity.LogDO;
import com.lingyi.mall.biz.system.model.query.LogQuery;
import com.lingyi.mall.biz.system.model.vo.LogVO;
import com.lingyi.mall.common.orm.util.BaseServicePro;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:32
 * @description
 */
public interface LogService extends BaseServicePro<LogRequest, LogVO, LogQuery, LogDO, Long> {


}
