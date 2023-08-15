package com.lingyi.mall.common.security.app.config;

import com.lingyi.mall.api.member.consumer.MemberFeignConsumer;
import com.lingyi.mall.common.base.filter.TrackIdFilter;
import com.lingyi.mall.common.redis.util.RedisUtil;
import com.lingyi.mall.common.security.app.filter.JwtTokenAuthorizationFilter;
import com.lingyi.mall.common.security.app.filter.JwtTokenBlacklistFilter;
import com.lingyi.mall.common.security.app.filter.JwtTokenRenewalFilter;
import com.lingyi.mall.common.security.app.util.AppRedisKeyUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;


/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 13:14
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }

    @Bean
    public TrackIdFilter trackIdFilter() {
        return new TrackIdFilter();
    }

    @Bean
    public JwtTokenBlacklistFilter jwtTokenBlacklistFilter(MessageSourceAccessor messageSourceAccessor, RedisUtil redisUtil, AppRedisKeyUtil appRedisKeyUtil) {
        JwtTokenBlacklistFilter jwtTokenBlacklistFilter = new JwtTokenBlacklistFilter();
        jwtTokenBlacklistFilter.setMessageSourceAccessor(messageSourceAccessor);
        jwtTokenBlacklistFilter.setRedisUtil(redisUtil);
        jwtTokenBlacklistFilter.setAppRedisKeyUtil(appRedisKeyUtil);
        return jwtTokenBlacklistFilter;
    }

    @Bean
    public JwtTokenAuthorizationFilter jwtTokenAuthorizationFilter(MessageSourceAccessor messageSourceAccessor) {
        JwtTokenAuthorizationFilter jwtTokenAuthorizationFilter = new JwtTokenAuthorizationFilter();
        jwtTokenAuthorizationFilter.setMessageSourceAccessor(messageSourceAccessor);
        return jwtTokenAuthorizationFilter;
    }

    @Bean
    public JwtTokenRenewalFilter jwtTokenRenewalFilter(MessageSourceAccessor messageSourceAccessor, MemberFeignConsumer memberFeignConsumer) {
        JwtTokenRenewalFilter jwtTokenRenewalFilter = new JwtTokenRenewalFilter();
        jwtTokenRenewalFilter.setMessageSourceAccessor(messageSourceAccessor);
        jwtTokenRenewalFilter.setMemberFeignConsumer(memberFeignConsumer);
        return jwtTokenRenewalFilter;
    }


    @Bean
    public FilterRegistrationBean<TrackIdFilter> trackIdFilterFilterRegistrationBean(TrackIdFilter trackIdFilter) {
        FilterRegistrationBean<TrackIdFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(trackIdFilter);
        bean.setOrder(1);
        return bean;
    }


    @Bean
    public FilterRegistrationBean<JwtTokenBlacklistFilter> jwtTokenBlacklistFilterFilterRegistrationBean(JwtTokenBlacklistFilter jwtTokenBlacklistFilter) {
        FilterRegistrationBean<JwtTokenBlacklistFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(jwtTokenBlacklistFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<JwtTokenAuthorizationFilter> jwtAuthorizationFilterFilterRegistrationBean(JwtTokenAuthorizationFilter jwtTokenAuthorizationFilter) {
        FilterRegistrationBean<JwtTokenAuthorizationFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(jwtTokenAuthorizationFilter);
        bean.setOrder(3);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<JwtTokenRenewalFilter> jwtTokenRenewalFilterRegistrationBean(JwtTokenRenewalFilter jwtTokenRenewalFilter) {
        FilterRegistrationBean<JwtTokenRenewalFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(jwtTokenRenewalFilter);
        bean.setOrder(4);
        return bean;
    }
}
