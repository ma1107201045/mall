package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.entity.MbsRole;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.biz.system.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.service.MbsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private final MbsRoleRepository mbsRoleRepository;

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
        return mbsUserRepository.findById(id).orElse(null);
    }

    @Override
    public Page<MbsUser> findByPageAndCondition(Pageable pageable, MbsUser mbsUser) {
        return mbsUserRepository.findAll(Example.of(mbsUser), pageable);
    }

    @Override
    public MbsUserVO getByUserName(String userName) {
        MbsUser mbsUser = mbsUserRepository.findOne(Example.of(MbsUser.builder().userName(userName).build())).orElseThrow();
        List<MbsRole> mbsRoles = mbsRoleRepository.findAllById(mbsUser.getMbsRoles().stream().map(MbsRole::getId).toList());
        return MbsUserVO.of(mbsUser, mbsRoles);
    }
}
