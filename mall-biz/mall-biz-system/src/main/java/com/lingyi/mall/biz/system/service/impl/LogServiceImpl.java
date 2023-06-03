package com.lingyi.mall.biz.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.entity.Log;
import com.lingyi.mall.api.system.enums.SystemFail;
import com.lingyi.mall.biz.system.mapper.LogMapper;
import com.lingyi.mall.biz.system.repository.LogRepository;
import com.lingyi.mall.biz.system.service.LogService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
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
    public void add(Log log) {
        logRepository.save(log);
    }

    @Override
    public void removeByIds(List<Long> ids) {
        logRepository.deleteAllById(ids);
    }

    @Override
    public void editById(Log log) {
        //获取日志信息
        Optional<Log> optional = logRepository.findById(log.getId());
        //判断日志是否为空
        if (optional.isEmpty()) {
            throw new BizException(SystemFail.LOG_NULL_ERROR);
        }
        //获取用户
        Log newLog = optional.get();
        //DTO转换Entity
        ConverterUtil.to(log, newLog);
        //更新
        logRepository.save(log);
    }

    @Override
    public Log findById(Long id) {
        return logMapper.selectById(id);
    }

    @Override
    public List<Log> findListByPageAndParam(BasePageParam pageParam, Log log) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize(), pageParam.getSort());
        return logMapper.selectListByParam(log);
    }
}
