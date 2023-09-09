package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnum;
import com.lingyi.mall.biz.member.mapper.MemberLevelMapper;
import com.lingyi.mall.biz.member.param.MemberLevelParam;
import com.lingyi.mall.biz.member.repository.MemberLevelRepository;
import com.lingyi.mall.biz.member.service.MemberLevelService;
import com.lingyi.mall.biz.member.vo.MemberLevelVO;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import com.lingyi.mall.common.core.exception.BizException;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.core.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:15
 * @description
 */
@Service
@RequiredArgsConstructor
public class MemberLevelServiceImpl implements MemberLevelService {

    private final MemberLevelRepository memberLevelRepository;

    private final MemberLevelMapper memberLevelMapper;

    @Override
    public void create(MemberLevelDO memberLevelDO) {
        memberLevelRepository.save(memberLevelDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        memberLevelRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(MemberLevelDO memberLevelDO) {
        var optional = memberLevelRepository.findById(memberLevelDO.getId());
        if (optional.isEmpty()) {
            throw new BizException(MemberFailEnum.MEMBER_LEVEL_NULL_ERROR);
        }
        var newMemberLevelDO = optional.get();
        ConverterUtil.to(memberLevelDO, newMemberLevelDO);
        memberLevelRepository.save(newMemberLevelDO);
    }

    @Override
    public MemberLevelVO readById(Long id) {
        return memberLevelMapper.selectById(id);
    }

    @Override
    public List<MemberLevelVO> readListByParam(MemberLevelParam memberLevelParam) {
        return memberLevelMapper.selectListByParam(memberLevelParam);
    }

    @Override
    public Long readDefaultLevelId() {
        var memberLevelDO = new MemberLevelDO();
        memberLevelDO.setIsDefaultLevel(WhetherEnum.Y.getCode());
        var optional = memberLevelRepository.findOne(Example.of(memberLevelDO));
        return optional.isPresent() ? optional.get().getId() : ObjectUtil.getNull();
    }
}
