package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnum;
import com.lingyi.mall.biz.member.mapper.MemberMapper;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.repository.MemberRepository;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.base.exception.BizException;
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
    public void create(MemberDO memberDO) {
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
            throw new BizException(MemberFailEnum.MEMBER_NULL_ERROR);
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
    public List<MemberVO> readListByParam(MemberParam memberParam) {
        return memberMapper.selectListByParam(memberParam);
    }

    @Override
    public Long register(MemberReqDTO memberReqDTO) {
        MemberDO memberDO = ConverterUtil.to(memberReqDTO, MemberDO.class);
        MemberLevelDO memberLevelDO = new MemberLevelDO();
        memberLevelDO.setId(memberReqDTO.getMemberLevelId());
        memberDO.setMemberLevelDO(memberLevelDO);
        create(memberDO);
        return memberDO.getId();
    }

    @Override
    public MemberRespDTO readByPhoneNumber(String phoneNumber) {
        return memberMapper.selectByPhoneNumber(phoneNumber);
    }


}
