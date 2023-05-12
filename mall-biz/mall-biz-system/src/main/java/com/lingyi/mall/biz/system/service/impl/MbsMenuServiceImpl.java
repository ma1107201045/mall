package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.entity.Menu;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.biz.system.mapper.MbsMenuMapper;
import com.lingyi.mall.biz.system.repository.MbsMenuRepository;
import com.lingyi.mall.biz.system.service.MbsMenuService;
import com.lingyi.mall.common.bean.param.BasePageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsMenuServiceImpl implements MbsMenuService {

    private final MbsMenuRepository mbsMenuRepository;

    private final MbsMenuMapper mbsMenuMapper;

    @Override
    public void add(Menu menu) {
        mbsMenuRepository.save(menu);
    }

    @Override
    public void removeByIds(Iterable<Long> ids) {
        mbsMenuRepository.deleteAllById(ids);
    }

    @Override
    public void editById(Menu menu) {
        mbsMenuRepository.save(menu);
    }

    @Override
    public Menu findById(Long id) {
        return null;
    }

    @Override
    public List<Menu> findListByPageAndParam(BasePageParam basePageParam, Menu menu) {
        return null;
    }


    @Override
    public List<MenuVO> findTreeByParentId(Long parentId) {
        List<MenuVO> menuVOList = mbsMenuMapper.selectListByParentId(parentId);
        menuVOList.forEach(menuTreeVO -> menuTreeVO.setMenuVOList(findTreeByParentId(menuTreeVO.getMenuId())));
        return menuVOList;
    }

    @Override
    public List<String> findPermissionByType(Integer type) {
        return mbsMenuMapper.selectPermissionByType(type);
    }

    @Override
    public List<MenuVO> findListByTypesAndParentId(List<Integer> types, Long parentId) {
        return mbsMenuMapper.selectListByTypesAndParentId(types, parentId);
    }

}
