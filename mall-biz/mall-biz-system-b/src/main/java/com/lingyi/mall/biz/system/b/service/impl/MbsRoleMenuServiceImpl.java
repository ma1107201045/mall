package com.lingyi.mall.biz.system.b.service.impl;

import com.lingyi.mall.api.system.b.dto.RoleMenuDTO;
import com.lingyi.mall.api.system.b.param.RoleMenuParma;
import com.lingyi.mall.api.system.b.vo.RoleMenuVO;
import com.lingyi.mall.biz.system.b.mapper.MbsRoleMenuMapper;
import com.lingyi.mall.biz.system.b.repository.MbsRoleMenuRepository;
import com.lingyi.mall.biz.system.b.service.MbsMenuService;
import com.lingyi.mall.biz.system.b.service.MbsRoleMenuService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/15 14:30
 * @description
 */
@Service
@RequiredArgsConstructor
public class MbsRoleMenuServiceImpl implements MbsRoleMenuService {
    private final MbsRoleMenuRepository mbsRoleMenuRepository;

    private final MbsRoleMenuMapper mbsRoleMenuMapper;

    private final MbsMenuService mbsMenuService;

    @Override
    public void add(RoleMenuDTO roleMenuDTO) {

    }

    @Override
    public void removeByIds(Iterable<Long> longs) {

    }

    @Override
    public void editById(RoleMenuDTO roleMenuDTO) {

    }

    @Override
    public RoleMenuVO findById(Long aLong) {
        return null;
    }

    @Override
    public List<RoleMenuVO> findListByPageAndParam(BasePageParam basePageDTO, RoleMenuParma roleMenuParma) {
        return null;
    }
}
