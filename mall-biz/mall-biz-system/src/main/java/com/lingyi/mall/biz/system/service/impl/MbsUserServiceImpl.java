package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.enums.MbsFailEnum;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsMenuVO;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.biz.system.constant.MbsConstant;
import com.lingyi.mall.biz.system.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.service.MbsMenuService;
import com.lingyi.mall.biz.system.service.MbsUserService;
import com.lingyi.mall.common.util.AssertUtil;
import com.lingyi.mall.common.util.PageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final MbsMenuService mbsMenuService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(MbsUser mbsUser) {
        MbsUserVO mbsUserVO = mbsUserMapper.selectByUserName(mbsUser.getUserName());
        //判断用户名称是否唯一
        AssertUtil.isNull(mbsUserVO, MbsFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(mbsUser.getPassword());
        mbsUser.setPassword(encodePassword);
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
    public List<MbsUser> findListByPageAndCondition(PageParam pageParam, MbsUser mbsUser) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        return mbsUserMapper.selectListByPageAndCondition(mbsUser);
    }

    @Override
    public MbsUserVO findUserAndMenuByUserNameAndMenuType(String userName, MbsMenuType mbsMenuType) {
        MbsUserVO mbsUserVO = mbsUserMapper.selectByUserName(userName);
        if (ObjUtil.isNotNull(mbsUserVO)) {
            List<MbsMenuVO> mbsMenuVOList = MbsConstant.USER_NAME_ADMIN.equals(userName) ? mbsMenuService.findListByType(mbsMenuType) : mbsMenuService.findListByTypeAndUserId(mbsMenuType, mbsUserVO.getUserId());
            mbsUserVO.setMbsMenuVOList(mbsMenuVOList);
        }
        return mbsUserVO;
    }
}
