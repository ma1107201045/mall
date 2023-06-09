package com.lingyi.mall.biz.base.service.impl;

import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import com.lingyi.mall.api.system.dto.MenuDTO;
import com.lingyi.mall.api.system.dto.UserPartDTO;

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
    public List<MenuDTO> findMenuTreeByUserName(String userName) {
        return userFeignConsumer.getMenuTreeByUserName(userName);
    }

    @Override
    public void editUserByUserId(Long userId, UserPartDTO userPartDTO) {
        userFeignConsumer.updatePartById(userId, userPartDTO);
    }
}
