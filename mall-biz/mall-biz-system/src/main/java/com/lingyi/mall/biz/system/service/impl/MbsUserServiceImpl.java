package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.enums.MbsFailEnum;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.api.system.vo.UserVO;
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
    public void add(User user) {
        Long id = mbsUserMapper.selectIdByUserName(user.getUserName());
        //判断用户名称是否唯一
        AssertUtil.isNull(id, MbsFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //保存
        mbsUserRepository.save(user);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsUserRepository.deleteAllById(ids);
    }

    @Override
    public void editById(User user) {
        mbsUserRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return mbsUserMapper.selectById(id);
    }

    @Override
    public List<User> findListByPageAndCondition(PageParam pageParam, User mbsUser) {
        PageHelper.startPage(pageParam.getCurrentPage(), pageParam.getPageSize());
        return mbsUserMapper.selectListByPageAndCondition(mbsUser);
    }

    @Override
    public UserVO findUserAndMenuByUserNameAndMenuType(String userName, MbsMenuType mbsMenuType) {
        UserVO userVO = mbsUserMapper.selectByUserName(userName);
        if (ObjUtil.isNotNull(userVO)) {
            List<MenuVO> menuVOList = MbsConstant.USER_NAME_ADMIN.equals(userName) ? mbsMenuService.findListByType(mbsMenuType) :
                    mbsMenuService.findListByTypeAndUserId(mbsMenuType, userVO.getUserId());
            userVO.setMenuVOList(menuVOList);
        }
        return userVO;
    }
}
