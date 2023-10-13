package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.biz.system.model.entity.LogDO;
import com.lingyi.mall.biz.system.dao.mapper.LogMapper;
import com.lingyi.mall.biz.system.model.param.LogParam;
import com.lingyi.mall.biz.system.dao.repository.LogRepository;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.biz.system.model.vo.LogVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:33
 * @description
 */
@Service
public class LogServiceImpl extends BaseServiceProImpl<LogRepository, LogMapper, LogReqDTO, LogVO, LogParam, LogDO, Long> implements LogService {


}
