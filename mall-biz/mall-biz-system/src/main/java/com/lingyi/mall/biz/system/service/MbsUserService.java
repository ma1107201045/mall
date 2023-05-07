package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.enums.MbsMenuType;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import com.lingyi.mall.common.util.BaseService;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/4 17:28
 * @description
 */
public interface MbsUserService extends BaseService<MbsUser, Long> {


    /**
     * 按照用户名称和按钮类型查询用户信息以及菜单信息
     *
     * @param userName 用户名称
     * @param menuType 菜单类型
     * @return MbsUserVO
     */
    MbsUserVO findUserAndMenuByUserNameAndMenuType(String userName, MbsMenuType menuType);
}
