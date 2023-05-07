package com.lingyi.mall.biz.system.mapper;

import com.lingyi.mall.api.system.entity.User;
import com.lingyi.mall.api.system.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

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
    User selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param mbsUser 用户信息
     * @return List<MbsUser>
     */
    List<User> selectListByPageAndCondition(User mbsUser);


    /**
     * 按照用户名称查询id
     *
     * @param userName 用户名称
     * @return Long
     */
    Long selectIdByUserName(String userName);


    /**
     * 按照用户名称查询
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserVO selectByUserName(String userName);


}
