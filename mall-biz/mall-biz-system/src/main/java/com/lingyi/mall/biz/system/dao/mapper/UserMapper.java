package com.lingyi.mall.biz.system.dao.mapper;


import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.biz.system.model.query.UserQuery;
import com.lingyi.mall.biz.system.model.vo.UserVO;
import com.lingyi.mall.common.orm.mybatis.MybatisMapperImplementation;
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
public interface UserMapper extends MybatisMapperImplementation<UserVO, UserQuery, Long> {


    /**
     * 按照用户名称查询
     *
     * @param userName 用户名称
     * @return MbsUserVO
     */
    UserResponse selectByUserName(String userName);

    /**
     * 按照用户名称和菜单类型集查询菜单列表
     *
     * @param userName  用户名称
     * @param menuTypes 按钮类型集
     * @return List<MenuTreeVO>
     */
    List<MenuResponse> selectMenusByUserNameAndMenuTypes(@Param("userName") String userName, @Param("menuTypes") List<Integer> menuTypes);

}
