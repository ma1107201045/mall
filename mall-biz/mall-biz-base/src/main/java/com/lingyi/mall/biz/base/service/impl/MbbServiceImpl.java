package com.lingyi.mall.biz.base.service.impl;

import com.lingyi.mall.api.system.consumer.MbsUserFeignConsumer;
import com.lingyi.mall.api.system.vo.MenuVO;
import com.lingyi.mall.biz.base.service.MbbService;
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
public class MbbServiceImpl implements MbbService {

    private final MbsUserFeignConsumer mbsUserFeignConsumer;

    @Override
    public List<MenuVO> findMenuTreeByUserId(String userName) {
        return mbsUserFeignConsumer.getMenuTreeByUserName(userName);
    }
}
