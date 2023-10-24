package com.lingyi.mall.biz.info.service.impl;

import com.lingyi.mall.biz.info.model.dto.LogDTO;
import com.lingyi.mall.biz.info.model.entity.LogDO;
import com.lingyi.mall.biz.info.dao.mapper.LogMapper;
import com.lingyi.mall.biz.info.model.param.LogParam;
import com.lingyi.mall.biz.info.dao.repositroy.SmsLogRepository;
import com.lingyi.mall.biz.info.service.LogService;
import com.lingyi.mall.biz.info.model.vo.LogVO;
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
public class LogServiceImpl extends BaseServiceProImpl<SmsLogRepository, LogMapper, LogDTO, LogVO, LogParam, LogDO, Long> implements LogService {


}
