package com.lingyi.mall.biz.system.b.service.impl;

import com.lingyi.mall.api.system.b.dto.RoleDTO;
import com.lingyi.mall.api.system.b.param.RoleParam;
import com.lingyi.mall.api.system.b.vo.RoleVO;
import com.lingyi.mall.biz.system.b.mapper.MbsRoleMapper;
import com.lingyi.mall.biz.system.b.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.b.service.MbsRoleService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/10 23:14
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsRoleServiceImpl implements MbsRoleService {

    private final MbsRoleRepository mbsRoleRepository;
    private final MbsRoleMapper mbsRoleMapper;

    @Override
    public void add(RoleDTO roleDTO) {

    }

    @Override
    public void removeByIds(Iterable<Long> longs) {

    }

    @Override
    public void editById(RoleDTO roleDTO) {

    }

    @Override
    public RoleVO findById(Long aLong) {
        return null;
    }

    @Override
    public List<RoleVO> findListByPageAndParam(BasePageParam basePageDTO, RoleParam roleParam) {
        return null;
    }
}
