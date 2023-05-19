package com.lingyi.mall.biz.system.b.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.b.constant.MbsConstant;
import com.lingyi.mall.api.system.b.dto.UserDTO;
import com.lingyi.mall.api.system.b.entity.User;
import com.lingyi.mall.api.system.b.entity.UserRole;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;
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

    private final PasswordEncoder passwordEncoder;

    private final MbsUserRepository mbsUserRepository;

    private final MbsUserMapper mbsUserMapper;

    private final MbsUserRoleService mbsUserRoleService;

    private final MbsMenuService mbsMenuService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserDTO userDTO) {
        //通过用户名称获取用户id
        Long id = mbsUserMapper.selectIdByUserName(userDTO.getUserName());
        //判断用户名称不存在
        AssertUtil.isNull(id, MbsFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //转换
        User user = BeanUtil.copyProperties(userDTO, User.class);
        //保存
        mbsUserRepository.save(user);
        //保存用户角色信息
        mbsUserRoleService.addList(user.getId(), userDTO.getRoleIds());
    }

    @Override
    public void removeByIds(List<Long> ids) {
        mbsUserRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editById(UserDTO userDTO) {
        //获取用户id
        Long id = userDTO.getId();
        //断言userId不为空
        AssertUtil.notNull(id, MbsFailEnum.USER_ID_NULL_ERROR);

        //通过用户名称获取用户id
        Long newId = mbsUserMapper.selectIdByUserName(userDTO.getUserName());
        boolean result = Objects.nonNull(id) && !Objects.equals(id, newId);

        //判断用户名称不存在
        AssertUtil.isFalse(result, MbsFailEnum.USER_NAME_EXIST_ERROR);
        //密码加密
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        //设置加密密码
        userDTO.setPassword(encodePassword);
        //DTO转换Entity
        User user = BeanUtil.copyProperties(userDTO, User.class);
        //更新
        mbsUserRepository.save(user);
        //删除用户角色集
        mbsUserRoleService.removeByUserId(id);
        //保存用户角色信息
        mbsUserRoleService.addList(id, userDTO.getRoleIds());
    }

    @Override
    public UserVO findById(Long id) {
        return mbsUserMapper.selectById(id);
    }

    @Override
    public List<UserVO> findListByPageAndParam(BasePageParam basePageParam, UserParam userParam) {
        PageHelper.startPage(basePageParam.getCurrentPage(), basePageParam.getPageSize(), basePageParam.getSort());
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
        menuVOList.forEach(menuTreeVO -> menuTreeVO.setMenus(findMenuTreeByUserNameAndMenuParentId(userName, menuParentId)));
        return menuVOList;
    }

}
