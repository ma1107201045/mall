package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.biz.system.dto.LogDTO;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.LogMapper;
import com.lingyi.mall.biz.system.param.LogParam;
import com.lingyi.mall.biz.system.repository.LogRepository;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.biz.system.vo.LogVO;
import com.lingyi.mall.common.core.exception.BizException;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServicePro;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:33
 * @description
 */
@Service
public class LogServiceImpl extends BaseServiceProImpl<LogRepository, LogMapper, LogDTO, LogVO, LogParam, LogDO, Long> implements LogService {

    @Override
    public void save(LogReqDTO logReqDTO) {
        var logDTO = ConverterUtil.to(logReqDTO, LogDTO.class);
        create(logDTO, LogDO.class);
    }


}
