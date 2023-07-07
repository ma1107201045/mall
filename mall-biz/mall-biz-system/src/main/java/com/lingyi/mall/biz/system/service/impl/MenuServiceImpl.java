package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.entity.MenuDO;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.mapper.MenuMapper;
import com.lingyi.mall.biz.system.param.MenuParam;
import com.lingyi.mall.biz.system.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.base.util.ConverterUtil;
import com.lingyi.mall.common.base.util.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(MenuDTO menuDTO) {
        //校验数据
        verifyAndGet(menuDTO, false);
        //DTO转换Entity
        MenuDO menuDO = ConverterUtil.to(menuDTO, MenuDO.class);
        //保存
        menuRepository.save(menuDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            menuRepository.deleteAllById(ids);
            deleteByIds(menuMapper.selectIdsByParentIds(ids));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(MenuDTO menuDTO) {
        //校验数据并且获取菜单
        MenuDO menuDO = verifyAndGet(menuDTO, true);
        //DTO转换Entity
        ConverterUtil.to(menuDTO, menuDO);
        //更新
        menuRepository.save(menuDO);
    }

    @Override
    public MenuVO readById(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<MenuVO> readListByParam(MenuParam menuParam) {
        return menuMapper.selectListByParam(menuParam);
    }

    @Override
    public List<MenuVO> readTree() {
        List<MenuVO> menuVOList = readListByParam(ObjectUtil.newInstance(MenuParam.class));
        return toTree(SystemConstant.MENU_ROOT_ID, menuVOList);
    }


    @Override
    public List<MenuResDTO> readListByTypes(List<Integer> types) {
        return menuMapper.selectListByTypes(types);
    }


    private MenuDO verifyAndGet(MenuDTO menuDTO, boolean isUpdate) {
        Integer type = menuDTO.getType();
        Long parentId = menuDTO.getParentId();
        //断言目录父级为root
        if (Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), type)) {
            boolean result = Objects.equals(SystemConstant.MENU_ROOT_ID, parentId);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_DIRECTORY_PARENT_ERROR);
        }
        //断言菜单类型不能为空
        Integer newType = menuMapper.selectTypeById(parentId);
        AssertUtil.notNull(newType, SystemFailEnum.MENU_TYPE_NOT_EXIST_ERROR);

        //断言菜单父级为root或者为目录
        if (Objects.equals(MenuTypeEnum.MENU.getCode(), type)) {
            boolean result = Objects.equals(SystemConstant.MENU_ROOT_ID, parentId) ||
                    Objects.equals(MenuTypeEnum.MENU.getCode(), type) && Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), newType);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_MENU_PARENT_ERROR);
        }

        //断言按钮父级为菜单
        if (Objects.equals(MenuTypeEnum.BUTTON.getCode(), type)) {
            boolean result = Objects.equals(MenuTypeEnum.MENU.getCode(), newType);
            AssertUtil.isTrue(result, SystemFailEnum.MENU_BUTTON_PARENT_ERROR);
        }
        MenuDO menuDO = null;
        if (isUpdate) {
            Optional<MenuDO> optional = menuRepository.findById(menuDTO.getId());
            //判断用户是否不为空
            AssertUtil.isFalse(optional.isEmpty(), SystemFailEnum.MENU_NULL_ERROR);
            menuDO = optional.get();
        }
        return menuDO;
    }


    private List<MenuVO> toTree(Long parentId, List<MenuVO> menuVOList) {
        List<MenuVO> menus = menuVOList.stream()
                .filter(menuVO -> menuVO.getParentId().equals(parentId))
                .sorted(Comparator.comparing(MenuVO::getSort))
                .toList();
        menus.forEach(menuVO -> menuVO.setChildren(toTree(menuVO.getId(), menuVOList)));
        return menus;
    }
}


