package com.lingyi.mall.common.security;

import com.lingyi.mall.common.web.filter.TrackIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

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
    public SecurityFilterChain securityFilterChain(HttpSecurity http, TrackIdFilter trackIdFilter) throws Exception {
        return http.addFilterBefore(trackIdFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/*/*/provider/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/webjars/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/doc.html").permitAll()
                .requestMatchers(HttpMethod.GET, "/v3/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().successHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("登录成功");
                    writer.flush();
                }).and()
                .logout().logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("注销成功");
                    writer.flush();
                }).and()
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
