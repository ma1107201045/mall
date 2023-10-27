package com.lingyi.mall.biz.info.service.impl;

import com.lingyi.mall.biz.info.model.dto.InfoLogDTO;
import com.lingyi.mall.biz.info.model.entity.InfoLogDO;
import com.lingyi.mall.biz.info.dao.mapper.InfoLogMapper;
import com.lingyi.mall.biz.info.model.param.InfoLogParam;
import com.lingyi.mall.biz.info.dao.repositroy.InfoLogRepository;
import com.lingyi.mall.biz.info.service.InfoLogService;
import com.lingyi.mall.biz.info.model.vo.InfoLogVO;
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
public class InfoLogServiceImpl extends BaseServiceProImpl<InfoLogRepository, InfoLogMapper, InfoLogDTO, InfoLogVO, InfoLogParam, InfoLogDO, Long> implements InfoLogService {


}
