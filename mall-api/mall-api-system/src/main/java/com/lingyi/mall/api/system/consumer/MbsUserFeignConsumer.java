package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.feign.MbsUserFeign;
import com.lingyi.mall.api.system.vo.UserVO;

import com.lingyi.mall.common.util.ServerResponse;
import com.lingyi.mall.common.util.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:41
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class MbsUserFeignConsumer {

    private final MbsUserFeign mbsUserFeign;

    public UserVO getUserAndMenuByUserName(String userName) {
        ServerResponse<UserVO> response = mbsUserFeign.getUserAndButtonByUserName(userName);
        if (response.getIsSuccess()) {
            return JSON.to(UserVO.class, response.getData());
        }
        throw new OpenFeignException(response.getBizCode(), response.getMessage());
    }
}
