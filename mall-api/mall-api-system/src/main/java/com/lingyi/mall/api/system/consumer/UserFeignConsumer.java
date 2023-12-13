package com.lingyi.mall.api.system.consumer;

import com.alibaba.fastjson2.JSON;
import com.lingyi.mall.api.system.response.MenuResponse;
import com.lingyi.mall.api.system.request.UserPartRequest;
import com.lingyi.mall.api.system.response.UserResponse;
import com.lingyi.mall.api.system.feign.UserFeign;
import com.lingyi.mall.common.core.exception.OpenFeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2023/5/3 20:41
 * @Description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserFeignConsumer {

    private final UserFeign userFeign;

    public void updatePartById(Long id, UserPartRequest userPartRequest) {
        log.info("入参:userPartRequest:{}", userPartRequest);
        var response = userFeign.updatePartById(id, userPartRequest);
        if (response.getIsSuccess()) {
            log.info("出参:Void:{}", JSON.toJSONString(response.getData()));
            return;
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public UserResponse getUserAndMenuPermissionsByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        var response = userFeign.getUserAndMenuPermissionsByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public List<MenuResponse> getMenuTreeByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        var response = userFeign.getMenuTreesByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:UserVO:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }

    public List<String> getMenuPermissionsByUserName(String userName) {
        log.info("入参:userName:{}", userName);
        var response = userFeign.getMenuPermissionsByUserName(userName);
        if (response.getIsSuccess()) {
            log.info("出参:permissions:{}", JSON.toJSONString(response.getData()));
            return response.getData();
        }
        throw new OpenFeignException(response.getCode(), response.getMessage());
    }
}
