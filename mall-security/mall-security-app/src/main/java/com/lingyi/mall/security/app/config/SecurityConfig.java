package com.lingyi.mall.security.app.config;

import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.common.core.filter.TrackIdFilter;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.security.app.filter.JwtTokenAuthorizationFilter;
import com.lingyi.mall.security.app.filter.JwtTokenBlacklistFilter;
import com.lingyi.mall.security.app.filter.JwtTokenRenewalFilter;
import com.lingyi.mall.security.app.util.RedisKeyUtil;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;


/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 13:14
 * @description
 */
@Configuration(value = "appSecurityConfig", proxyBeanMethods = false)
public class SecurityConfig {


    @Bean
    public JwtTokenBlacklistFilter jwtTokenBlacklistFilter(MessageSourceAccessor messageSourceAccessor, RedisUtil redisUtil, RedisKeyUtil redisKeyUtil) {
        var jwtTokenBlacklistFilter = new JwtTokenBlacklistFilter();
        jwtTokenBlacklistFilter.setMessageSourceAccessor(messageSourceAccessor);
        jwtTokenBlacklistFilter.setRedisUtil(redisUtil);
        jwtTokenBlacklistFilter.setAppRedisKeyUtil(redisKeyUtil);
        return jwtTokenBlacklistFilter;
    }

    @Bean
    public JwtTokenAuthorizationFilter jwtTokenAuthorizationFilter(MessageSourceAccessor messageSourceAccessor) {
        var jwtTokenAuthorizationFilter = new JwtTokenAuthorizationFilter();
        jwtTokenAuthorizationFilter.setMessageSourceAccessor(messageSourceAccessor);
        return jwtTokenAuthorizationFilter;
    }

    @Bean
    public JwtTokenRenewalFilter jwtTokenRenewalFilter(MessageSourceAccessor messageSourceAccessor, MemberFeignConsumer memberFeignConsumer) {
        var jwtTokenRenewalFilter = new JwtTokenRenewalFilter();
        jwtTokenRenewalFilter.setMessageSourceAccessor(messageSourceAccessor);
        jwtTokenRenewalFilter.setMemberFeignConsumer(memberFeignConsumer);
        return jwtTokenRenewalFilter;
    }


    @Bean
    public FilterRegistrationBean<Filter> trackIdFilterFilterRegistrationBean(TrackIdFilter trackIdFilter) {
        var bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(trackIdFilter);
        bean.setOrder(1);
        return bean;
    }


    @Bean
    public FilterRegistrationBean<Filter> jwtTokenBlacklistFilterFilterRegistrationBean(JwtTokenBlacklistFilter jwtTokenBlacklistFilter) {
        var bean = new FilterRegistrationBean<>();
        bean.setFilter(jwtTokenBlacklistFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> jwtAuthorizationFilterFilterRegistrationBean(JwtTokenAuthorizationFilter jwtTokenAuthorizationFilter) {
        var bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(jwtTokenAuthorizationFilter);
        bean.setOrder(3);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> jwtTokenRenewalFilterRegistrationBean(JwtTokenRenewalFilter jwtTokenRenewalFilter) {
        var bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(jwtTokenRenewalFilter);
        bean.setOrder(4);
        return bean;
    }
}
