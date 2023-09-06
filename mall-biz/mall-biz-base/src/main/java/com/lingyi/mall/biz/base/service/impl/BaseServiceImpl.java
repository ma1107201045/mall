package com.lingyi.mall.biz.base.service.impl;

import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.dto.MenuRespDTO;
import com.lingyi.mall.api.system.dto.UserPartReqDTO;

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
    public void updateUserByUserId(Long userId, UserPartReqDTO userPartReqDTO) {
        userFeignConsumer.updatePartById(userId, userPartReqDTO);
    }

    @Override
    public List<MenuRespDTO> readMenuTreesByUserName(String userName) {
        return userFeignConsumer.getMenuTreeByUserName(userName);
    }

    @Override
    public List<String> readMenuPermissionsByUserName(String userName) {
        return userFeignConsumer.getMenuPermissionsByUserName(userName);
    }


}
