package com.lingyi.mall.security.app.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.jwt.StpLogicJwtForMixin;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
public class SaTokenConfigure {

    // Sa-Token 整合 jwt (Simple 简单模式)
    // @Bean
    public StpLogic getStpLogicJwtForSimple() {
        return new StpLogicJwtForSimple();
    }

    // Sa-Token 整合 jwt (Mixin 混入模式)
    //  @Bean
    public StpLogic getStpLogicJwtForMixin() {
        return new StpLogicJwtForMixin();
    }

    // Sa-Token 整合 jwt (Stateless 无状态模式)
    @Bean
    public StpLogic getStpLogicJwtForStateless() {
        return new StpLogicJwtForStateless();
    }

    @Bean
    public StpInterface stpInterface() {
        return new StpInterface() {
            @Override
            public List<String> getPermissionList(Object loginId, String loginType) {
                return Collections.emptyList();
            }

            @Override
            public List<String> getRoleList(Object loginId, String loginType) {
                return Collections.emptyList();
            }
        };
    }
}
