package com.lingyi.mall.biz.member.service.impl;

import com.lingyi.mall.biz.member.model.dto.LevelDTO;
import com.lingyi.mall.biz.member.model.entity.LevelDO;
import com.lingyi.mall.biz.member.dao.mapper.LevelMapper;
import com.lingyi.mall.biz.member.model.param.LevelParam;
import com.lingyi.mall.biz.member.dao.repository.LevelRepository;
import com.lingyi.mall.biz.member.service.LevelService;
import com.lingyi.mall.biz.member.model.vo.LevelVO;
import com.lingyi.mall.common.core.enums.WhetherEnum;
import com.lingyi.mall.common.core.util.ObjectUtil;
import com.lingyi.mall.common.orm.util.BaseServiceProImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/7/12 9:15
 * @description
 */
@Service
@RequiredArgsConstructor
public class LevelServiceImpl extends BaseServiceProImpl<LevelRepository, LevelMapper, LevelDTO, LevelVO, LevelParam, LevelDO, Long> implements LevelService {

    @Override
    public Long queryDefaultLevelId() {
        var memberLevelDO = new LevelDO();
        memberLevelDO.setIsDefaultLevel(WhetherEnum.Y.getCode());
        var optional = jpaRepository.findOne(Example.of(memberLevelDO));
        return optional.isPresent() ? optional.get().getId() : ObjectUtil.getNull();
    }
}
