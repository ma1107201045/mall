package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.entity.MbsMenu;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsMenuVO;
import com.lingyi.mall.biz.system.mapper.MbsMenuMapper;
import com.lingyi.mall.biz.system.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.repository.MbsMenuRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.service.MbsMenuService;
import com.lingyi.mall.common.util.PageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsMenuServiceImpl implements MbsMenuService {

    private final MbsMenuRepository mbsMenuRepository;

    private final MbsMenuMapper mbsMenuMapper;

    @Override
    public void add(MbsMenu mbsMenu) {
        mbsMenuRepository.save(mbsMenu);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsMenuRepository.deleteAllById(ids);
    }

    @Override
    public void editById(MbsMenu mbsMenu) {
        mbsMenuRepository.save(mbsMenu);
    }

    @Override
    public MbsMenu findById(Long aLong) {
        return null;
    }

    @Override
    public List<MbsMenu> findListByPageAndCondition(PageParam pageParam, MbsMenu mbsMenu) {
        return null;
    }

    @Override
    public List<MbsMenuVO> findListByType(MbsMenuType mbsMenuType) {
        return mbsMenuMapper.selectListByType(mbsMenuType.getCode());
    }

    @Override
    public List<MbsMenuVO> findListByTypeAndUserId(MbsMenuType mbsMenuType, Long userId) {
        return mbsMenuMapper.selectListByTypeAndUserId(mbsMenuType.getCode(), userId);
    }
}
