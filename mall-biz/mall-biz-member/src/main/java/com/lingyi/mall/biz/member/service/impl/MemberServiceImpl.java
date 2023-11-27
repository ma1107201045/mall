package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.reqeust.MemberRequest;
import com.lingyi.mall.api.member.response.MemberResponse;
import com.lingyi.mall.biz.member.converter.MemberConverter;
import com.lingyi.mall.biz.member.model.dto.MemberDTO;
import com.lingyi.mall.biz.member.model.dto.MemberPartDTO;
import com.lingyi.mall.biz.member.model.entity.MemberDO;
import com.lingyi.mall.biz.member.dao.mapper.MemberMapper;
import com.lingyi.mall.biz.member.model.param.MemberParam;
import com.lingyi.mall.biz.member.dao.repository.MemberRepository;
import com.lingyi.mall.biz.member.service.MemberService;
import com.lingyi.mall.biz.member.model.vo.MemberVO;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Long register(MemberRequest memberRequest) {
        var memberDO = MemberConverter.INSTANCE.of(memberRequest);
        create(memberDO);
        return memberDO.getId();
    }

    @Override
    public MemberResponse readByPhoneNumber(String phoneNumber) {
        return mybatisMapper.selectByPhoneNumber(phoneNumber);
    }


}
