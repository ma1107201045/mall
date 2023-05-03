package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.MbsUserFeign;
import com.lingyi.mall.api.system.vo.MbsUserAndPermissionsVO;
import com.lingyi.mall.common.exception.OpenFeignException;
import com.lingyi.mall.common.util.ServerResponse;
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

    public MbsUserAndPermissionsVO getUserAndPermissionByUserName(String userName) {
        ServerResponse<MbsUserAndPermissionsVO> response = mbsUserFeign.getUserAndPermissionsByUserName(userName);
        if (response.getIsSuccess()) {
            return JSON.to(MbsUserAndPermissionsVO.class, response.getData());
        }
        throw new OpenFeignException(response.getCode(), response.getMsg());
    }
}
