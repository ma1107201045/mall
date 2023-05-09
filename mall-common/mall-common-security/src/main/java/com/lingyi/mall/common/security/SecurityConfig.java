package com.lingyi.mall.common.security;

import com.lingyi.mall.common.security.handler.JsonAuthenticationFailureHandler;
import com.lingyi.mall.common.security.handler.JsonAuthenticationSuccessHandler;
import com.lingyi.mall.common.security.handler.JsonLogoutSuccessHandler;
import com.lingyi.mall.common.web.filter.TrackIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http, TrackIdFilter trackIdFilter,
                                                   AuthenticationSuccessHandler authenticationSuccessHandler,
                                                   AuthenticationFailureHandler authenticationFailureHandler,
                                                   LogoutSuccessHandler logoutSuccessHandler) throws Exception {
        return http.addFilterBefore(trackIdFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/doc.html", "/webjars/**", "/v3/**", "/favicon.ico", "/mab/captcha", "/*/*/provider/**").permitAll()
                .requestMatchers("/*/*/provider/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
                .logout().logoutSuccessHandler(logoutSuccessHandler).and()
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
