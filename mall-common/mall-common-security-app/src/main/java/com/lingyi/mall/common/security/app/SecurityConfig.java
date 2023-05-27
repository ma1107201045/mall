package com.lingyi.mall.common.security.app;

import com.lingyi.mall.common.security.app.authentication.DaoAuthenticationProvider;
import com.lingyi.mall.common.security.app.authentication.filter.LogoutFilter;
import com.lingyi.mall.common.security.app.authentication.service.MemberDetailsService;
import com.lingyi.mall.common.security.app.authentication.filter.PhoneNumberVerificationCodeAuthenticationFilter;
import com.lingyi.mall.common.security.app.handler.*;
import com.lingyi.mall.common.security.app.service.impl.MemberDetailsServiceImpl;
import com.lingyi.mall.common.web.filter.TrackIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * @author maweiyan
 * @email 1107201045@qq.com
 * @datetime 2023/5/2 13:14
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    public static final String LOGIN_PROCESSING_URL = "/maa/app/login";
    public static final String LOGOUT_URL = "/maa/app/logout";


    @Bean
    public TrackIdFilter trackIdFilter() {
        return new TrackIdFilter();
    }

    @Bean
    public PhoneNumberVerificationCodeAuthenticationFilter phoneNumberVerificationCodeAuthenticationFilter(AuthenticationManager authenticationManager,
                                                                                                           AuthenticationSuccessHandler authenticationSuccessHandler,
                                                                                                           AuthenticationFailureHandler authenticationFailureHandler) {
        PhoneNumberVerificationCodeAuthenticationFilter phoneNumberVerificationCodeAuthenticationFilter = new PhoneNumberVerificationCodeAuthenticationFilter();
        phoneNumberVerificationCodeAuthenticationFilter.setAuthenticationManager(authenticationManager);
        phoneNumberVerificationCodeAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        phoneNumberVerificationCodeAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        phoneNumberVerificationCodeAuthenticationFilter.setFilterProcessesUrl(LOGIN_PROCESSING_URL);
        return phoneNumberVerificationCodeAuthenticationFilter;
    }

    @Bean
    public LogoutFilter logoutFilter(LogoutSuccessHandler logoutSuccessHandler) {
        LogoutFilter logoutFilter = new LogoutFilter(logoutSuccessHandler);
        logoutFilter.setFilterProcessesUrl(LOGOUT_URL);
        return logoutFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(MemberDetailsService memberDetailsService) {
        return new DaoAuthenticationProvider(memberDetailsService);
    }

    @Bean
    public MemberDetailsService memberDetailsService() {
        return new MemberDetailsServiceImpl();
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   TrackIdFilter trackIdFilter,
                                                   PhoneNumberVerificationCodeAuthenticationFilter phoneNumberVerificationCodeAuthenticationFilter,
                                                   AuthenticationEntryPoint authenticationEntryPoint,
                                                   AccessDeniedHandler accessDeniedHandler) throws Exception {
        return http.addFilterBefore(trackIdFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(phoneNumberVerificationCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/swagger-ui/**",
                        "/doc.html",
                        "/webjars/**",
                        "/v3/**",
                        "/favicon.ico",
                        "/mab/captcha",
                        "/mws/admin/provider/users/permissions").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().disable()
                .logout().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler).and()
                .cors().disable()
                .csrf().disable()
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
