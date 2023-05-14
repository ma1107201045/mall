package com.lingyi.mall.biz.system.b.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.b.constant.MbsConstant;
import com.lingyi.mall.api.system.b.dto.UserDTO;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.enums.MbsFailEnum;
import com.lingyi.mall.api.system.b.enums.MbsMenuType;
import com.lingyi.mall.api.system.b.param.UserParam;
import com.lingyi.mall.api.system.b.vo.MenuVO;
import com.lingyi.mall.api.system.b.vo.UserVO;
import com.lingyi.mall.biz.system.b.mapper.MbsUserMapper;
import com.lingyi.mall.biz.system.b.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.b.service.MbsMenuService;
import com.lingyi.mall.biz.system.b.service.MbsUserRoleService;
import com.lingyi.mall.biz.system.b.service.MbsUserService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import com.lingyi.mall.common.bean.util.AssertUtil;
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

    private final PasswordEncoder passwordEncoder;

    private final MbsUserRepository mbsUserRepository;

    private final MbsUserMapper mbsUserMapper;

    private final MbsUserRoleService mbsUserRoleService;

    private final MbsMenuService mbsMenuService;


    @Override
    public void add(UserDTO userDTO) {
        //通过用户名称获取用户id
        Long id = mbsUserMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称是否唯一
        AssertUtil.isNull(id, MbsFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //转换
        User user = BeanUtil.copyProperties(userDTO, User.class);
        //保存
        mbsUserRepository.save(user);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsUserRepository.deleteAllById(ids);
    }

    @Override
    public void editById(UserDTO userDTO) {
        //转换
        User user = BeanUtil.copyProperties(userDTO, User.class);
        mbsUserRepository.save(user);
    }

    @Override
    public UserVO findById(Long id) {
        return mbsUserMapper.selectById(id);
    }

    @Override
    public List<UserVO> findListByPageAndParam(BasePageParam basePageParam, UserParam userParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize());
        return mbsUserMapper.selectListByParam(userParam);
    }

    @Override
    public UserVO findUserAndMenuPermissionsByUserName(String userName) {
        UserVO userVO = mbsUserMapper.selectByUserName(userName);
        if (ObjUtil.isNull(userVO)) {
            return userVO;
        }
        List<String> permissions;
        Integer type = MbsMenuType.BUTTON.getCode();
        if (!MbsConstant.USER_NAME_ADMIN.equals(userName)) {
            permissions = mbsUserMapper.selectMenuPermissionsByUserIdAndMenuType(userVO.getUserId(), type);
        } else {
            permissions = mbsMenuService.findPermissionByType(type);
        }
        userVO.setPermissions(permissions);
        return userVO;
    }


    @Override
    public List<MenuVO> findMenuTreeByUserNameAndMenuParentId(String userName, Long menuParentId) {
        List<MenuVO> menuVOList;
        List<Integer> menuTypes = CollUtil.newArrayList(MbsMenuType.DIRECTORY.getCode(), MbsMenuType.MENU.getCode());
        if (!MbsConstant.USER_NAME_ADMIN.equals(userName)) {
            menuVOList = mbsUserMapper.selectMenusByUserNameAndMenuTypesAndMenuParentId(userName, menuTypes, menuParentId);
        } else {
            menuVOList = mbsMenuService.findListByTypesAndParentId(menuTypes, menuParentId);
        }
        menuVOList.forEach(menuTreeVO -> menuTreeVO.setMenuVOList(findMenuTreeByUserNameAndMenuParentId(userName, menuParentId)));
        return menuVOList;
    }

}
