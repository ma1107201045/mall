package com.lingyi.mall.biz.system.service.impl;

import com.lingyi.mall.api.system.vo.MbsUserAndPermissionsVO;
import com.lingyi.mall.biz.system.repository.MbsRoleRepository;
import com.lingyi.mall.biz.system.repository.MbsUserRepository;
import com.lingyi.mall.biz.system.service.MbsUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:04
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsUserServiceImpl implements MbsUserService {

    private final MbsUserRepository mbsUserRepository;

    private final MbsRoleRepository mbsRoleRepository;


    @Override
    public MbsUserAndPermissionsVO getUserAndPermissionsByUserName(String userName) {

        return null;
    }
}
