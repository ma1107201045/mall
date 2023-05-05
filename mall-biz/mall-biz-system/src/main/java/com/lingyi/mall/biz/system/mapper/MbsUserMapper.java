package com.lingyi.mall.biz.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:52
 * @description
 */
public interface MbsUserMapper extends BaseMapper<MbsUser> {
    MbsUser selectById(Long id);

    IPage<MbsUser> selectListByPageAndCondition(@Param("page") IPage<MbsUser> iPage, @Param("mbsUser") MbsUser mbsUser);

    MbsUserVO selectOneByUserNameAndMenuType(@Param("userName") String userName, @Param("menuType") Integer menuType);
}
