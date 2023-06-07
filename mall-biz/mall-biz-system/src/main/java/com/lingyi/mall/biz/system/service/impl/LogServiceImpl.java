package com.lingyi.mall.biz.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.entity.LogDO;
import com.lingyi.mall.api.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.LogMapper;
import com.lingyi.mall.biz.system.repository.LogRepository;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.query.BasePageQuery;
import com.lingyi.mall.common.base.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
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
    public void create(LogDO logDO) {
        logRepository.save(logDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        logRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(LogDO logDO) {
        //获取日志信息
        Optional<LogDO> optional = logRepository.findById(logDO.getId());
        //判断日志是否为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFailEnum.LOG_NULL_ERROR);
        }
        //获取用户
        LogDO newLogDO = optional.get();
        //DTO转换Entity
        ConverterUtil.to(logDO, newLogDO);
        //更新
        logRepository.save(newLogDO);
    }

    @Override
    public LogDO readById(Long id) {
        return logMapper.selectById(id);
    }

    @Override
    public List<LogDO> readListByPageAndQuery(BasePageQuery pageParam, LogDO logDO) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize(), pageParam.getSort());
        return logMapper.selectListByParam(logDO);
    }
}
