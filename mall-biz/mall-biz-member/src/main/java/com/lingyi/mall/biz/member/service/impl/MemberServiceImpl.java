package com.lingyi.mall.biz.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnumEnum;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.biz.member.mapper.MemberMapper;
import com.lingyi.mall.biz.member.repository.MemberRepository;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.param.BasePageParam;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:09
 * @description
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    @Override
    public void  create(MemberDO memberDO) {
        memberRepository.save(memberDO);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        memberRepository.deleteAllById(ids);
    }

    @Override
    public void updateById(MemberDO memberDO) {
        Optional<MemberDO> optional = memberRepository.findById(memberDO.getId());
        if (optional.isEmpty()) {
            throw new BizException(MemberFailEnumEnum.MEMBER_NULL_ERROR);
        }
        MemberDO newMemberDO = optional.get();
        ConverterUtil.to(memberDO, newMemberDO);
        memberRepository.save(newMemberDO);
    }

    @Override
    public MemberVO readById(Long id) {
        return memberMapper.selectById(id);
    }

    @Override
    public List<MemberVO> readListByPageAndQuery(BasePageParam pageParam, MemberParam memberParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize(), pageParam.getSort());
        return memberMapper.selectListByParam(memberParam);
    }

    @Override
    public MemberReqDTO findByPhoneNumber(String phoneNumber) {
        return memberMapper.selectByPhoneNumber(phoneNumber);
    }


}
