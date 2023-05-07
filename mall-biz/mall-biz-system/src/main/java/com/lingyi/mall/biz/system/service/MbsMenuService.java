package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.entity.MbsMenu;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsMenuVO;
import com.lingyi.mall.common.util.BaseService;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/7 15:28
 * @Description:
 */
public interface MbsMenuService extends BaseService<MbsMenu, Long> {

    /**
     * 按照类型查询
     *
     * @param mbsMenuType 菜单类型
     * @return List<MbsMenuVO>
     */
    List<MbsMenuVO> findListByType(MbsMenuType mbsMenuType);

    /**
     * 按照用户名称和菜单类型查询
     *
     * @param mbsMenuType 菜单类型
     * @param userId      用户id
     * @return List<MbsMenuVO>
     */
    List<MbsMenuVO> findListByTypeAndUserId(MbsMenuType mbsMenuType, Long userId);
}
