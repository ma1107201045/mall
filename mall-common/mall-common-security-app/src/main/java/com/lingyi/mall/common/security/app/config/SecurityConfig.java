package com.lingyi.mall.common.security.app.config;

import com.lingyi.mall.common.base.filter.TrackIdFilter;
import com.lingyi.mall.common.security.app.filter.IgnoreRequestFilter;
import com.lingyi.mall.common.security.app.filter.JwtAuthorizationFilter;
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
    public TrackIdFilter trackIdFilter() {
        return new TrackIdFilter();
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }

    @Bean
    public FilterRegistrationBean<TrackIdFilter> trackIdFilterFilterRegistrationBean() {
        FilterRegistrationBean<TrackIdFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new TrackIdFilter());
        bean.addUrlPatterns("/**");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<IgnoreRequestFilter> ignoreUrlFilterFilterRegistrationBean() {
        FilterRegistrationBean<IgnoreRequestFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new IgnoreRequestFilter());
        bean.addUrlPatterns("/**");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilterFilterRegistrationBean() {
        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new JwtAuthorizationFilter());
        bean.addUrlPatterns("/**");
        bean.setOrder(3);
        return bean;
    }

}
