package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.entity.MbsUser;
import com.lingyi.mall.api.system.vo.MbsMenuVO;
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
    /**
     * 通过id查询
     *
     * @param id id
     * @return MbsUser
     */
    MbsUser selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param mbsUser 用户信息
     * @return List<MbsUser>
     */
    List<MbsUser> selectListByPageAndCondition(MbsUser mbsUser);


    /**
     * 按照用户名称查询
     *
     * @param userName 用户名
     * @return MbsUserVO
     */
    MbsUserVO selectByUserName(String userName);


}
