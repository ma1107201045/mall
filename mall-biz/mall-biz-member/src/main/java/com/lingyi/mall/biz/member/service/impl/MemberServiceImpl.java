package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.dto.MemberReqDTO;
import com.lingyi.mall.api.member.dto.MemberRespDTO;
import com.lingyi.mall.biz.member.converter.MemberConverter;
import com.lingyi.mall.biz.member.dto.MemberDTO;
import com.lingyi.mall.biz.member.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.entity.MemberDO;
import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.biz.member.enums.MemberFailEnum;
import com.lingyi.mall.biz.member.mapper.MemberMapper;
import com.lingyi.mall.biz.member.param.MemberParam;
import com.lingyi.mall.biz.member.repository.MemberRepository;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.biz.member.vo.MemberVO;
import com.lingyi.mall.common.core.exception.BizException;
import com.lingyi.mall.common.core.util.ConverterUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/25 15:09
 * @description
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends BaseServiceProImpl<MemberRepository, MemberMapper, MemberDTO, MemberVO, MemberParam, MemberDO, Long> implements MemberService {

    @Override
    public void updateIsEnableById(MemberPartDTO memberPartDTO) {

    }

    @Override
    public Long register(MemberReqDTO memberReqDTO) {
        var memberDTO = ConverterUtil.to(memberReqDTO, MemberDTO.class);
        var memberDO = MemberConverter.INSTANCE.of(memberDTO);
        create(memberDTO, memberDO);
        return memberDO.getId();
    }

    @Override
    public MemberRespDTO readByPhoneNumber(String phoneNumber) {
        return mybatisMapper.selectByPhoneNumber(phoneNumber);
    }


}
