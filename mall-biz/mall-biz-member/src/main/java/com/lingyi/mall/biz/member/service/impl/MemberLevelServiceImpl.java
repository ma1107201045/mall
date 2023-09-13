package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.biz.member.dto.MemberLevelDTO;
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
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
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
public class MemberLevelServiceImpl extends BaseServiceProImpl<MemberLevelRepository, MemberLevelMapper, MemberLevelDTO, MemberLevelVO, MemberLevelParam, MemberLevelDO, Long> implements MemberLevelService {

    @Override
    public Long queryDefaultLevelId() {
        var memberLevelDO = new MemberLevelDO();
        memberLevelDO.setIsDefaultLevel(WhetherEnum.Y.getCode());
        var optional = jpaRepository.findOne(Example.of(memberLevelDO));
        return optional.isPresent() ? optional.get().getId() : ObjectUtil.getNull();
    }
}
