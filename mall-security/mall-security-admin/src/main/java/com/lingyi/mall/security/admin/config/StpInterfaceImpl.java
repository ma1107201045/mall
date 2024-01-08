package com.lingyi.mall.security.admin.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollUtil;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author: maweiyan
 * @Email 1107201045@qq.com
 * @DateTime: 2024/1/8 21:03
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    private final UserFeignConsumer userFeignConsumer;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return userFeignConsumer.getMenuPermissionsByUserName((String) loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return Collections.emptyList();
    }
}
