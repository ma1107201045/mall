package com.lingyi.mall.security.admin.config;

import cn.dev33.satoken.stp.StpInterface;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/9 13:56
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class AdminSaTokenConfigure {

    private static final String PERMISSION_SEPARATOR = ",";

    @Bean
    public StpInterface stpInterface(UserFeignConsumer userFeignConsumer) {
        return new StpInterface() {
            @Override
            public List<String> getPermissionList(Object loginId, String loginType) {
                List<String> permissions = userFeignConsumer.getMenuPermissionsById(Long.valueOf((String) loginId));
                permissions = permissions.stream()
                        .flatMap(permission -> Arrays.stream(permission.split(PERMISSION_SEPARATOR)))
                        .collect(Collectors.toList());
                return permissions;
            }

            @Override
            public List<String> getRoleList(Object loginId, String loginType) {
                return Collections.emptyList();
            }
        };
    }
}
