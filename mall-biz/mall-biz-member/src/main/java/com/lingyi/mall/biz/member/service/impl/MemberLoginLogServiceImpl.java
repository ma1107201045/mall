package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.MemberLoginLogReqDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLoginLogDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnum;
import com.lingyi.mall.biz.member.param.MemberLoginParam;
import com.lingyi.mall.biz.member.vo.MemberLoginLogVO;
import com.lingyi.mall.biz.member.mapper.MemberLoginLogMapper;
import com.lingyi.mall.biz.member.repository.MemberLoginLogRepository;
import com.lingyi.mall.biz.member.service.MemberLoginLogService;
import com.lingyi.mall.common.core.exception.BizException;
import com.lingyi.mall.common.core.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        var optional = memberLoginLogRepository.findById(memberLoginLogDO.getId());
        //判断日志是否为空
        if (optional.isEmpty()) {
            throw new BizException(MemberFailEnum.MEMBER_LOGIN_LOG_NULL_ERROR);
        }
        //获取用户
        var newMemberLoginLogDO = optional.get();
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
    public List<MemberLoginLogVO> readListByParam(MemberLoginParam memberLoginParam) {
        return memberLoginLogMapper.selectListByParam(memberLoginParam);
    }


    @Override
    public void save(MemberLoginLogReqDTO memberLoginLogReqDTO) {
        var memberLoginLogDO = ConverterUtil.to(memberLoginLogReqDTO, MemberLoginLogDO.class);
        var memberDO = new MemberDO();
        memberDO.setId(memberLoginLogReqDTO.getMemberUserId());
        memberLoginLogDO.setMemberDO(memberDO);
        create(memberLoginLogDO);
    }
}
