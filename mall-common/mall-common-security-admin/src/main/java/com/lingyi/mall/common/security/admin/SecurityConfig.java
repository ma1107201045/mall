package com.lingyi.mall.common.security.admin;

import com.lingyi.mall.common.base.constant.SecurityBaseConstant;
import com.lingyi.mall.common.security.admin.handler.*;
import com.lingyi.mall.common.web.filter.TrackIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 13:14
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    public static final String LOGIN_PROCESSING_URL = "/system/admin/login";
    public static final String LOGOUT_URL = "/system/admin/logout";
    public static final String REMEMBER_ME_KEY = "199726ma.";

    @Bean
    public OncePerRequestFilter oncePerRequestFilter() {
        return new TrackIdFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new JsonAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new JsonAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new JsonLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JsonAuthenticationEntryPoint();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new JsonAccessDeniedHandler();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, OncePerRequestFilter oncePerRequestFilter,
                                                   AuthenticationSuccessHandler authenticationSuccessHandler,
                                                   AuthenticationFailureHandler authenticationFailureHandler,
                                                   LogoutSuccessHandler logoutSuccessHandler,
                                                   AuthenticationEntryPoint authenticationEntryPoint,
                                                   AccessDeniedHandler accessDeniedHandler) throws Exception {
        return http.addFilterBefore(oncePerRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizeHttpRequestsConfigurer -> authorizeHttpRequestsConfigurer.requestMatchers(HttpMethod.GET,
                        "/swagger-ui/**",
                        "/doc.html",
                        "/webjars/**",
                        "/v3/**",
                        "/system/admin/provider/users/permissions").permitAll().anyRequest().authenticated())
                .formLogin(formLoginConfigurer -> formLoginConfigurer.loginProcessingUrl(LOGIN_PROCESSING_URL)
                        .usernameParameter(SecurityBaseConstant.USERNAME_PARAMETER)
                        .successHandler(authenticationSuccessHandler)
                        .failureHandler(authenticationFailureHandler))
                .logout(logoutConfigurer -> logoutConfigurer.logoutUrl(LOGOUT_URL)
                        .logoutSuccessHandler(logoutSuccessHandler))
                .rememberMe(rememberMeConfigurer -> rememberMeConfigurer.key(REMEMBER_ME_KEY)
                        .rememberMeParameter(SecurityBaseConstant.REMEMBER_ME_PARAMETER)
                        .rememberMeCookieName(SecurityBaseConstant.REMEMBER_ME_COOKIE_NAME))
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint((authenticationEntryPoint))
                        .accessDeniedHandler(accessDeniedHandler))
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers("doc.html",
//                "/v3/**",
//                "/favicon.ico",
//                "/images/**",
//                "/js/**",
//                "/webjars/**");
//    }


}
