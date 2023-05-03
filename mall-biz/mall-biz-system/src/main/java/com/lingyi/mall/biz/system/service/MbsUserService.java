package com.lingyi.mall.biz.system.service;

import com.lingyi.mall.api.system.vo.MbsUserAndPermissionsVO;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:04
 * @Description:
 */
public interface MbsUserService {


    /**
     * 按照用户名称查询用户信息和权限
     *
     * @param userName 用户名称
     * @return 用户信息
     */
    MbsUserAndPermissionsVO getUserAndPermissionsByUserName(String userName);
}
