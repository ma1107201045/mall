package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.api.member.vo.MemberVO;
import com.lingyi.mall.biz.member.mapper.MemberMapper;
import com.lingyi.mall.biz.member.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mbmMemberMapper;

    @Override
    public MemberVO findByPhoneNumber(String phoneNumber) {
        return mbmMemberMapper.selectByPhoneNumber(phoneNumber);
    }
}
