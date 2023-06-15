package com.lingyi.mall.biz.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.lingyi.mall.api.system.dto.MenuResDTO;
import com.lingyi.mall.biz.system.constant.SystemConstant;
import com.lingyi.mall.biz.system.dto.MenuDTO;
import com.lingyi.mall.biz.system.entity.MenuDO;
import com.lingyi.mall.biz.system.enums.SystemFailEnum;
import com.lingyi.mall.biz.system.enums.MenuTypeEnum;
import com.lingyi.mall.biz.system.query.MenuQuery;
import com.lingyi.mall.biz.system.vo.MenuVO;
import com.lingyi.mall.biz.system.mapper.MenuMapper;
import com.lingyi.mall.biz.system.repository.MenuRepository;
import com.lingyi.mall.biz.system.service.MenuService;
import com.lingyi.mall.common.base.exception.BizException;
import com.lingyi.mall.common.base.query.BasePageQuery;
import com.lingyi.mall.common.base.util.AssertUtil;
import com.lingyi.mall.common.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        MenuDO menuDO = BeanUtil.copyProperties(menuDTO, MenuDO.class);
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
    public List<MenuVO> readListByPageAndQuery(BasePageQuery pageQuery, MenuQuery menuQuery) {
        startPage(pageQuery);
        return menuMapper.selectListByParam(menuQuery);
    }


    @Override
    public List<MenuVO> findTreeByParentId(Long parentId) {
        List<MenuVO> menus = menuMapper.selectListByParentId(parentId);
        menus.forEach(menu -> menu.setMenus(findTreeByParentId(menu.getId())));
        return menus;
    }

    @Override
    public List<String> findPermissionsByType(Integer type) {
        return menuMapper.selectPermissionsByType(type);
    }

    @Override
    public List<MenuResDTO> findListByTypesAndParentId(List<Integer> types, Long parentId) {
        return menuMapper.selectListByTypesAndParentId(types, parentId);
    }


    private MenuDO verifyAndGet(MenuDTO menuDTO, boolean isEdit) {
        Integer type = menuDTO.getType();
        Long parentId = menuDTO.getParentId();
        //断言目录父级为root
        boolean result01 = Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), type) && Objects.equals(SystemConstant.MENU_ROOT_ID, parentId);
        AssertUtil.isTrue(result01, SystemFailEnum.MENU_DIRECTORY_PARENT_ERROR);

        //断言菜单类型不能为空
        Integer newType = menuMapper.selectTypeById(parentId);
        AssertUtil.notNull(newType, SystemFailEnum.MENU_TYPE_NOT_EXIST_ERROR);

        //断言菜单父级为root或者父级为目录
        boolean result02 = Objects.equals(MenuTypeEnum.MENU.getCode(), type) && Objects.equals(SystemConstant.MENU_ROOT_ID, parentId) ||
                Objects.equals(MenuTypeEnum.MENU.getCode(), type) && Objects.equals(MenuTypeEnum.DIRECTORY.getCode(), newType);
        AssertUtil.isTrue(result02, SystemFailEnum.MENU_MENU_PARENT_ERROR);

        //断言按钮父级为菜单
        boolean result03 = Objects.equals(MenuTypeEnum.BUTTON.getCode(), type) && Objects.equals(MenuTypeEnum.MENU.getCode(), newType);
        AssertUtil.isTrue(result03, SystemFailEnum.MENU_BUTTON_PARENT_ERROR);
        MenuDO menuDO = null;
        if (isEdit) {
            Optional<MenuDO> optional = menuRepository.findById(menuDTO.getId());
            //判断用户是否不为空
            if (optional.isEmpty()) {
                throw new BizException(SystemFailEnum.MENU_NULL_ERROR);
            }
            menuDO = optional.get();
        }
        return menuDO;
    }

}
