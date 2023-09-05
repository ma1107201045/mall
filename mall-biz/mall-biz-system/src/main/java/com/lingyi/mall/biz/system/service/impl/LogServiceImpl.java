package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.dto.LogReqDTO;
import com.lingyi.mall.biz.system.entity.LogDO;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.LogMapper;
import com.lingyi.mall.biz.system.param.LogParam;
import com.lingyi.mall.biz.system.repository.LogRepository;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/6/3 9:33
 * @description
 */
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    private final LogMapper logMapper;

    @Override
    public void create(LogReqDTO logReqDTO) {
        var logDO = ConverterUtil.to(logReqDTO, LogDO.class);
        logRepository.save(logDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        logRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(LogReqDTO logReqDTO) {
        //获取日志信息
        var optional = logRepository.findById(logReqDTO.getId());
        //判断日志是否为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.LOG_NULL_ERROR);
        }
        var logDO = optional.get();
        //转换
        ConverterUtil.to(logReqDTO, logDO);
        //保存
        logRepository.save(logDO);
    }

    @Override
    public LogDO readById(Long id) {
        return logMapper.selectById(id);
    }

    @Override
    public List<LogDO> readListByParam(LogParam logParam) {
        return logMapper.selectListByParam(logParam);
    }

}
