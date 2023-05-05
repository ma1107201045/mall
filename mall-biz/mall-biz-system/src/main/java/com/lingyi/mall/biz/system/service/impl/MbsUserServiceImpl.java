package com.lingyi.mall.biz.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.biz.system.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.service.MbsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:04
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsUserServiceImpl implements MbsUserService {

    private final MbsUserRepository mbsUserRepository;

    private final MbsUserMapper mbsUserMapper;

    @Override
    public void add(MbsUser mbsUser) {
        mbsUserRepository.save(mbsUser);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsUserRepository.deleteAllById(ids);
    }

    @Override
    public void editById(MbsUser mbsUser) {
        mbsUserRepository.save(mbsUser);
    }

    @Override
    public MbsUser findById(Long id) {
        return mbsUserMapper.selectById(id);
    }

    @Override
    public IPage<MbsUser> findListPageAndCondition(IPage<MbsUser> iPage, MbsUser mbsUser) {
        return mbsUserMapper.selectListByPageAndCondition(iPage, mbsUser);
    }

    @Override
    public MbsUserVO findOneByUserNameAndMenuType(String userName, MbsMenuType mbsMenuType) {
        return mbsUserMapper.selectOneByUserNameAndMenuType(userName, mbsMenuType.getCode());
    }
}
