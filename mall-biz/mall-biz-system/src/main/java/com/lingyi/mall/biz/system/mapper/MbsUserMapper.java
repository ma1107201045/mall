package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.vo.MbsUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 14:52
 * @description
 */
@Mapper
public interface MbsUserMapper {
    MbsUser selectById(Long id);

    List<MbsUser> selectListByPageAndCondition(MbsUser mbsUser);

    MbsUserVO selectByUserNameAndMenuType(@Param("userName") String userName, @Param("menuType") Integer menuType);
}
