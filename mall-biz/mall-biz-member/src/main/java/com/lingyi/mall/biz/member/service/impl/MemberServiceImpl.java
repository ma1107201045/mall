package com.lingyi.mall.biz.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.member.entity.Member;
import com.lingyi.mall.api.member.enums.MemberFailEnum;
import com.lingyi.mall.api.member.param.MemberParam;
import com.lingyi.mall.api.member.vo.MemberVO;
import com.lingyi.mall.biz.member.mapper.MemberMapper;
import com.lingyi.mall.biz.member.repository.MemberRepository;
import com.lingyi.mall.biz.member.service.MemberService;
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
 * @datetime 2023/5/25 15:09
 * @description
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    @Override
    public void add(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void removeByIds(List<Long> ids) {
        memberRepository.deleteAllById(ids);
    }

    @Override
    public void editById(Member member) {
        Optional<Member> optional = memberRepository.findById(member.getId());
        if (optional.isEmpty()) {
            throw new BizException(MemberFailEnum.MEMBER_NULL_ERROR);
        }
        Member newMember = optional.get();
        ConverterUtil.to(member, newMember);
        memberRepository.save(newMember);
    }

    @Override
    public MemberVO findById(Long id) {
        return memberMapper.selectById(id);
    }

    @Override
    public List<MemberVO> findListByPageAndParam(BasePageParam pageParam, MemberParam memberParam) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize(), pageParam.getSort());
        return memberMapper.selectListByParam(memberParam);
    }

    @Override
    public MemberVO findByPhoneNumber(String phoneNumber) {
        return memberMapper.selectByPhoneNumber(phoneNumber);
    }


}