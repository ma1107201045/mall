package com.lingyi.mall.biz.system.b.mapper;

import com.lingyi.mall.api.system.b.entity.UserRole;
import com.lingyi.mall.api.system.b.param.UserParam;
import com.lingyi.mall.api.system.b.param.UserRoleParam;
import com.lingyi.mall.api.system.b.vo.UserRoleVO;
import com.lingyi.mall.api.system.b.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/5 15:04
 * @description
 */
@Mapper
public interface MbsUserRoleMapper {


    /**
     * 通过id查询
     *
     * @param id id
     * @return UserRoleVO
     */
    UserRoleVO selectById(Long id);

    /**
     * 按照分页信息和条件查询
     *
     * @param userRoleParam 用户角色信息
     * @return List<UserRoleVO>
     */
    List<UserRoleVO> selectListByParam(UserRoleParam userRoleParam);
}
