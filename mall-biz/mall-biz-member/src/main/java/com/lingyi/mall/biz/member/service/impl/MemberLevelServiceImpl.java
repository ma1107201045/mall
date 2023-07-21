package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.biz.member.entity.MemberLevelDO;
import com.lingyi.mall.biz.member.repository.MemberLevelRepository;
import com.lingyi.mall.biz.member.service.MemberLevelService;
import com.lingyi.mall.common.base.enums.WhetherEnum;
import com.lingyi.mall.common.base.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Long readDefaultLevelId() {
        MemberLevelDO memberLevelDO = new MemberLevelDO();
        memberLevelDO.setIsDefaultLevel(WhetherEnum.Y.getCode());
        Optional<MemberLevelDO> optional = memberLevelRepository.findOne(Example.of(memberLevelDO));
        return optional.isPresent() ? optional.get().getId() : ObjectUtil.getNull();
    }
}
