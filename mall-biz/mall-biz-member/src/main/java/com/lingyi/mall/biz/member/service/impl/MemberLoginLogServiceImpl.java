package com.lingyi.mall.biz.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnumEnum;
import com.lingyi.mall.biz.member.vo.MemberLoginLogVO;
import com.lingyi.mall.biz.member.mapper.MemberLoginLogMapper;
import com.lingyi.mall.biz.member.repository.MemberLoginLogRepository;
import com.lingyi.mall.biz.member.service.MemberLoginLogService;
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
 * @datetime 2023/6/6 9:23
 * @description
 */
@Service
@RequiredArgsConstructor
public class MemberLoginLogServiceImpl implements MemberLoginLogService {

    private final MemberLoginLogRepository memberLoginLogRepository;

    private final MemberLoginLogMapper memberLoginLogMapper;

    @Override
    public void create(MemberLoginLogDO memberLoginLogDO) {
        memberLoginLogRepository.save(memberLoginLogDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        memberLoginLogRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(MemberLoginLogDO memberLoginLogDO) {
        //获取日志信息
        Optional<MemberLoginLogDO> optional = memberLoginLogRepository.findById(memberLoginLogDO.getId());
        //判断日志是否为空
        if (optional.isEmpty()) {
            throw new BizException(MemberFailEnumEnum.MEMBER_LOGIN_LOG_NULL_ERROR);
        }
        //获取用户
        MemberLoginLogDO newMemberLoginLogDO = optional.get();
        //DTO转换Entity
        ConverterUtil.to(memberLoginLogDO, newMemberLoginLogDO);
        //更新
        memberLoginLogRepository.save(memberLoginLogDO);
    }

    @Override
    public MemberLoginLogVO readById(Long id) {
        return memberLoginLogMapper.selectById(id);
    }

    @Override
    public List<MemberLoginLogVO> readListByPageAndQuery(BasePageQuery pageParam, MemberLoginLogDO memberLoginLogDO) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize(), pageParam.getSort());
        return memberLoginLogMapper.selectListByParam(memberLoginLogDO);
    }
}
