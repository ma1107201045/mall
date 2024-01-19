package com.lingyi.mall.security.admin.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.StpInterface;
import com.lingyi.mall.api.system.consumer.UserFeignConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * @Author: maweiyan
 * @Email: 1107201045@qq.com
 * @DateTime: 2024/1/9 13:56
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class SaTokenConfigure {

    // Sa-Token 参数配置，参考文档：https://sa-token.cc
    // 此配置会覆盖 application.yml 中的配置
    @Bean
    @Primary
    public SaTokenConfig saTokenConfig() {
        SaTokenConfig config = new SaTokenConfig();
        // token 名称（同时也是 cookie 名称）
        config.setTokenName("satoken");
        // token 有效期（单位：秒），默认30天，-1代表永不过期
        config.setTimeout(30 * 24 * 60 * 60);
        // token 最低活跃频率（单位：秒），如果 token 超过此时间没有访问系统就会被冻结，默认-1 代表不限制，永不冻结
        config.setActiveTimeout(-1);
        // 是否允许同一账号多地同时登录（为 true 时允许一起登录，为 false 时新登录挤掉旧登录）
        config.setIsConcurrent(true);
        // 在多人登录同一账号时，是否共用一个 token （为 true 时所有登录共用一个 token，为 false 时每次登录新建一个 token）
        config.setIsShare(true);
        // token 风格
        config.setTokenStyle("uuid");
        // 是否输出操作日志
        config.setIsLog(false);
        return config;
    }

    @Bean
    public StpInterface stpInterface(UserFeignConsumer userFeignConsumer) {
        return new StpInterface() {
            @Override
            public List<String> getPermissionList(Object loginId, String loginType) {
                return userFeignConsumer.getMenuPermissionsById(Long.valueOf((String) loginId));
            }

            @Override
            public List<String> getRoleList(Object loginId, String loginType) {
                return null;
            }
        };
    }
}
