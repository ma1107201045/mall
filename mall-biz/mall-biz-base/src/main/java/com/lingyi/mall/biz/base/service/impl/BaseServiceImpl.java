package com.lingyi.mall.biz.base.service.impl;

import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;

import com.lingyi.mall.biz.base.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/12 22:36
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {

    private final UserFeignConsumer userFeignConsumer;

    @Override
    public void updateUserByUserId(Long userId, UserPartRequest userPartRequest) {
        userFeignConsumer.updatePartById(userId, userPartRequest);
    }

    @Override
    public List<MenuResponse> readMenuTreesByUserId(Long userId) {
        return userFeignConsumer.getMenuTreeById(userId);
    }

    @Override
    public List<String> readMenuPermissionsByUserId(Long userId) {
        return userFeignConsumer.getMenuPermissionsById(userId);
    }


}
