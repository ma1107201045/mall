package com.lingyi.mall.biz.system.mapper;


import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserRespDTO;
import com.lingyi.mall.biz.system.param.UserParam;
import com.lingyi.mall.biz.system.vo.UserVO;
import com.lingyi.mall.common.base.util.MybatisMapper;
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
public interface UserMapper extends MybatisMapper<Long, UserParam, UserVO> {

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
    UserRespDTO selectByUserName(String userName);

    /**
     * 按照用户名称和菜单类型集查询菜单列表
     *
     * @param userName  用户名称
     * @param menuTypes 按钮类型集
     * @return List<MenuTreeVO>
     */
    List<MenuRespDTO> selectMenusByUserNameAndMenuTypes(@Param("userName") String userName, @Param("menuTypes") List<Integer> menuTypes);


}
